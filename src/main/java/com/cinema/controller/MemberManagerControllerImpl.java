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
import com.cinema.domain.MemberManagerDto;
import com.cinema.domain.PageDto;
import com.cinema.service.MemberManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/memberManager/*")
@AllArgsConstructor
public class MemberManagerControllerImpl implements MemberManagerController {

	
	private MemberManagerService memberManagerService;

	@Override
	@GetMapping("/list")
	public void memberList(Criteria cri, Model model) {
		model.addAttribute("memberList", memberManagerService.memberList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, memberManagerService.memberGetTotal()));
	}

	@Override
	@GetMapping({ "/member", "/modify" })
	public void memberGet(@RequestParam("memberNo") long memberNo, Model model) {
		model.addAttribute("member", memberManagerService.memberGet(memberNo));
	}

	@Override
	@PostMapping("/modify")
	public String memberModify(MemberManagerDto memberManagerDto, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		boolean result = memberManagerService.memberModify(memberManagerDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/memberManager/list";
	}

}
