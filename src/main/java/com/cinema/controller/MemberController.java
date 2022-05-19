package com.cinema.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.MemberVO;
import com.cinema.domain.MovieVO;
import com.cinema.service.MemberService;
import com.cinema.service.MovieService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MovieService movieService;

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
			// alert창을 이용해서 ***(아이디)님, 가입을 축하합니다. 라고 전달할 예정이므로 RedirectAttributes를 이용합니다.
			rttr.addFlashAttribute("message", memberVO.getMember_id()+"님 가입을 축하드립니다.");
		} else {
			// 실패시
			url = "redirect:/member/join";
			rttr.addFlashAttribute("message", "회원가입에 실패했습니다. 반복 시 관리자에게 문의해주세요.");
		}
		return url;

	}

	// 로그인 페이지 이동
	@GetMapping("/login")
	public void loginGET(Model model) {
		List<MovieVO> movieList = movieService.movieList();
		int main = (int) (Math.random() * movieList.size());
		model.addAttribute("main", movieList.get(main));
		log.info("move to login page..........");

	}

	// 로그인
	@PostMapping("/login")
	public String loginPost(MemberVO memberVO, HttpServletRequest request,RedirectAttributes rttr) {
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
			rttr.addFlashAttribute("message", loginedMemberVO.getMember_name()+"님 환영합니다.");
			url = "redirect:/";
			if(loginedMemberVO.getDel_yn().equals("Y")) {
				rttr.addFlashAttribute("message", "회원 탈퇴가 진행된 계정입니다. 다시 확인 해 주십시오.");
				session.invalidate();
			}
			
		} else {
			// 실패시
			String message= "로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인 후 시도해주십시오.";
			rttr.addFlashAttribute("message", message);
			url = "redirect:/member/login";
		}
		return url;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request,RedirectAttributes rttr) {
		// 세션을 초기화하기 위해 세션을 불러옵니다.
		HttpSession session = request.getSession();
		// 세션 초기화
		session.invalidate();
		rttr.addFlashAttribute("message", "로그아웃되었습니다.");
		return "redirect:/";
	}

	@GetMapping("/modify")
	public void modify() {
		log.info("move to modify page..........");
	}
	
	@PostMapping("/modify")
	public String modifyMember(MemberVO memberVO,RedirectAttributes rttr) {
		int result = memberService.memberModify(memberVO);
		// 마이바티스는 insert에 성공했을경우 결과값으로 1을 리턴합니다.
		String url = ""; // 이동할 url 입니다.
		if (result == 1) {
			// 성공시
			rttr.addFlashAttribute("message", "회원정보변경에 성공했습니다. 다시 로그인해주십시오.");
			//로그아웃
			url = "redirect:/member/logout";
		} else {
			// 실패시
			rttr.addFlashAttribute("message","오류가 발생했습니다. 다시 시도해주십시오");
			url = "redirect:/member/modify";
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
	//findId로 이동
	@GetMapping("/findId")
	public void moveToFindId() {
		
		log.info("move to findId page..........");
		
	}
	//아이디 찾기 기능
	@PostMapping("/findId")
	public String findId(@RequestParam Map<String,String> emailMap,Model model) {
		log.info(emailMap);
		List<MemberVO> memberList = memberService.findId(emailMap);
		model.addAttribute("memberList",memberList);
		return "/member/idList";
	}
	
	@PostMapping("/deleteMember")
	public String deleteMember(HttpServletRequest request,RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		int result = memberService.delete(memberVO.getMember_no());
		session.invalidate();
		rttr.addFlashAttribute("message", "회원탈퇴가 완료되었습니다. 감사합니다.");
		return "redirect:/";
	}
	
	
}