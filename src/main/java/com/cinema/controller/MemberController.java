package com.cinema.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.MemberVO;
import com.cinema.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 회원가입 페이지 이동
	@GetMapping("/join")
	public void joinGET() {

		log.info("move to join page..........");

	}

	// 회원가입
	@PostMapping("/join")
	public String joinPOST(MemberVO memberVO, RedirectAttributes rttr) {

		int result = memberService.memberJoin(memberVO);
		// 마이바티스는 insert에 성공했을경우 결과값으로 1을 리턴합니다.
		String url = ""; // 이동할 url 입니다.
		if (result == 1) {
			// 성공시
			url = "redirect:/";
			// Modal창을 이용해서 ***(아이디)님, 가입을 축하합니다. 라고 전달할 예정이므로 RedirectAttributes를 이용합니다.
			rttr.addAttribute("result", memberVO.getMember_id());
		} else {
			// 실패시
			url = "/member/join";
		}
		return url;

	}

	// 로그인 페이지 이동
	@GetMapping("/login")
	public void loginGET() {

		log.info("move to login page..........");

	}

	// 로그인
	@PostMapping("/login")
	public String loginPost(MemberVO memberVO, HttpServletRequest request, Model model) {
		MemberVO loginedMemberVO = memberService.login(memberVO);
		// 이동될 url
		String url = "";
		// 세션에 저장하기위해서 세션을 불러옵니다.
		HttpSession session = request.getSession();
		if (loginedMemberVO != null) {
			// 성공시
			// 세션에 memberVO를 저장해 전달합니다.
			session.setAttribute("memberVO", loginedMemberVO);
			// 세션에 isLogOn값을 true로 저장해 전달합니다.
			session.setAttribute("isLogOn", true);
			url = "redirect:/";
		} else {
			// 실패시
			model.addAttribute("tried", "false");
			url = "/member/login";
		}
		return url;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		// 세션을 초기화하기 위해 세션을 불러옵니다.
		HttpSession session = request.getSession();
		// 세션 초기화
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/modify")
	public void modify() {
		log.info("move to modify page..........");
	}
	
	@PostMapping("/modify")
	public String modifyMember(MemberVO memberVO,Model model) {
		int result = memberService.memberModify(memberVO);
		// 마이바티스는 insert에 성공했을경우 결과값으로 1을 리턴합니다.
		String url = ""; // 이동할 url 입니다.
		if (result == 1) {
			// 성공시
			model.addAttribute("message", "회원정보변경에 성공했습니다. 다시 로그인해주십시오.");
			//로그아웃
			url = "redirect:/member/logout";
		} else {
			// 실패시
			model.addAttribute("message","오류가 발생했습니다. 다시 시도해주십시오");
			url = "/member/modify";
		}
		return url;
	}
	// ajax를 이용한 중복검사이므로 json타입을 리턴합니다. RestController 대신 해당 메소드에만 @ResponseBody 를
	// 선언합니다.

	@ResponseBody
	@PostMapping("/overlapped")
	public ResponseEntity<String> overlapped(String id) {
		// 있는 아이디 일경우 (사용불가) false , 없는 아이디일 경우(사용가능) true 리턴
		String result = memberService.overlapped(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}