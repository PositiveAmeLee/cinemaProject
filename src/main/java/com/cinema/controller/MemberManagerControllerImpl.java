package com.cinema.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@Autowired
	MemberManagerService memberManagerService;
	
	@Autowired
	MemberManagerDto memberManagerDto;
	
	@Override
	@GetMapping("/list")
	public void memberList(Criteria cri, Model model) {
		model.addAttribute("list",memberManagerService.loadMemberList(cri));
		model.addAttribute("pageMaker", new PageDto(cri,memberManagerService.memberGetTotal()));
	}

	@Override
	@GetMapping("/member")
	public void memberDetail(long memberNo, Model model) {
		model.addAttribute("member", memberManagerService.loadMemberDetail(memberNo));
	}

	@Override
	@PostMapping("/modify")
	public String memberDetailModify(MemberManagerDto memberManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = memberManagerService.modifyMemberDetail(memberManagerDto);
		if(result==true) {
			rttr.addFlashAttribute("result","success");
		} else rttr.addFlashAttribute("result","fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/manager_memberDetail";
	}
	@Override
	@GetMapping("/search")
	public String memberSearch(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		MemberManagerDto memberManagerDto;
		memberManagerDto =  (MemberManagerDto) memberManagerService.searchMember(cri);
		if(memberManagerDto!=null) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("search", memberManagerDto);
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/manager_memberList";
	}

}
