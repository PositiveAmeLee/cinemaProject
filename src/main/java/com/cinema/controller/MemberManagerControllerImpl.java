package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;
import com.cinema.domain.PageDto;
import com.cinema.service.MemberManagerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/memberManager/*")
@RequiredArgsConstructor //생성자 주입
public class MemberManagerControllerImpl {
	//@Autowired 생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private final MemberManagerService memberManagerService;

	/*
	 * parameter
	 * Criteria의 필드값
	 * 페이징을 위해 사용됩니다.
	 * */
	@GetMapping("/list")
	public void memberList(Criteria cri, Model model) {
		model.addAttribute("memberList", memberManagerService.memberList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, memberManagerService.memberGetTotal()));
	}

	/*
	 * parameter
	 * member 조회를 위한 primary key(long memberNo)
	 * */
	@GetMapping({ "/member", "/modify" })
	public void memberGet(@RequestParam("memberNo") long memberNo, Model model) {
		model.addAttribute("member", memberManagerService.memberGet(memberNo));
	}

	/*
	 * parameter
	 * MemberDto.MemberModify의 필드값
	 * Criteria cri의 필드값
	 * 수정 후 페이징처리에 사용합니다.
	 * */
	@PostMapping("/modify")
	public String memberModify(MemberDto.MemberModifyDto modifyDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = memberManagerService.memberModify(modifyDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/memberManager/list";
	}

}
