package com.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.MemberDto;
import com.cinema.domain.MovieDto;
import com.cinema.service.MemberService;
import com.cinema.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
@RequiredArgsConstructor // 생성자 주입
public class MemberController {
	// @Autowired 생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private MemberService memberService;
	// 회원가입페이지 , 로그인페이지에서 영화이미지를 띄워주기위한 용도입니다.
	private MovieService movieService;

	// 회원가입 페이지 이동
	@GetMapping("/join")
	public void joinGET(Model model) {
		List<MovieDto.MovieResultDto> movieList = movieService.movieList();
		int main = (int) (Math.random() * movieList.size());
		model.addAttribute("main", movieList.get(main));
	}

	/*
	 * parameter MemberDto.MemberCreateDto의 필드값
	 * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
	 */
	@PostMapping("/join")
	public String joinPOST(MemberDto.MemberCreateDto createDto, RedirectAttributes rttr) {
		int result = memberService.memberJoin(createDto);
		String url = "";
		if (result == 1) {
			url = "redirect:/";
			rttr.addFlashAttribute("message", createDto.getMemberId() + "님 가입을 축하드립니다.");
		} else {
			url = "redirect:/member/join";
			rttr.addFlashAttribute("message", "회원가입에 실패했습니다. 반복 시 관리자에게 문의해주세요.");
		}
		return url;
	}

	// 로그인 페이지 이동
	@GetMapping("/login")
	public void loginGET(Model model) {
		List<MovieDto.MovieResultDto> movieList = movieService.movieList();
		int main = (int) (Math.random() * movieList.size());
		model.addAttribute("main", movieList.get(main));
		log.info("move to login page..........");
	}

	/*
	 * parameter
	 * MemberDto.MemberLoginRequestDto의 필드값
	 * 세션에 저장하기위한 request
	 * */
	@PostMapping("/login")
	public String loginPost(MemberDto.MemberLoginRequestDto requestDto, HttpServletRequest request, RedirectAttributes rttr) {
		MemberDto.MemberLoginResponseDto responseDto = memberService.login(requestDto);
		String url = "";
		HttpSession session = request.getSession();
		if (responseDto != null) {
			session.setAttribute("responseDto", responseDto);
			session.setAttribute("isLogOn", true);
			rttr.addFlashAttribute("message", responseDto.getMemberName() + "님 환영합니다.");
			url = "redirect:/";
			if (responseDto.getDel_yn().equals("Y")) {
				rttr.addFlashAttribute("message", "회원 탈퇴가 진행된 계정입니다. 다시 확인 해 주십시오.");
				session.invalidate();
			}else if (responseDto.getMemberId().equals("admin")) {
				url = "redirect:/manager";
			}
		} else {
			String message = "로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인 후 시도해주십시오.";
			rttr.addFlashAttribute("message", message);
			url = "redirect:/member/login";
		}
		return url;
	}

	/*
	 * parameter
	 * 세션을 초기화하기 위한 request
	 * */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		session.invalidate();
		rttr.addFlashAttribute("message", "로그아웃되었습니다.");
		return "redirect:/";
	}
	//회원정보수정 페이지 이동
	@GetMapping("/modify")
	public void modify() {
	}

	/*
	 * parameter
	 * MemberDto.MemberModifyDto의 필드 값
	 * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
	 * */
	@PostMapping("/modify")
	public String modifyMember(MemberDto.MemberModifyDto modifyDto, RedirectAttributes rttr) {
		int result = memberService.memberModify(modifyDto);
		String url = ""; 
		if (result == 1) {
			rttr.addFlashAttribute("message", "회원정보변경에 성공했습니다. 다시 로그인해주십시오.");
			url = "redirect:/member/logout";
		} else {
			rttr.addFlashAttribute("message", "오류가 발생했습니다. 다시 시도해주십시오");
			url = "redirect:/member/modify";
		}
		return url;
	}

	@ResponseBody
	@PostMapping("/overlapped")
	public ResponseEntity<String> overlapped(String id) {
		// 있는 아이디 일경우 (사용불가) false , 없는 아이디일 경우(사용가능) true 리턴
		String result = memberService.overlapped(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 아이디 찾기 페이지 이동
	@GetMapping("/findId")
	public void moveToFindId() {
	}

	/*
	 * parameter
	 * MemberDto.MemberFindIdDto의 필드값
	 * */
	@PostMapping("/findId")
	public String findId(MemberDto.MemberFindIdDto findIdDto, Model model) {
		List<String> memberIdList = memberService.findId(findIdDto);
		model.addAttribute("memberIdList", memberIdList);
		return "/member/idList";
	}

	/*
	 * parameter
	 * member 삭제를 위한 primary key(Long memberno)
	 * 회원탈퇴 후 세션을 비우기 위한 request
	 * 삭제는 soft delete를 사용합니다.
	 * */
	@PostMapping("/deleteMember")
	public String deleteMember(long memberno,HttpServletRequest request, RedirectAttributes rttr) {
		int result = memberService.delete(memberno);
		if(result==1) {
			HttpSession session = request.getSession();
			session.invalidate();
			rttr.addFlashAttribute("message", "회원탈퇴가 완료되었습니다. 감사합니다.");
		}else {
			rttr.addFlashAttribute("message", "회원탈퇴가 실패했습니다. 관리자에게 문의해주십시오.");
		}
		return "redirect:/";
	}

}