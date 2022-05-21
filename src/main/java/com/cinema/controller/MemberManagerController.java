package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;

public interface MemberManagerController {
	
	public void memberList(Criteria cri, Model model);
	
	public void memberGet(@RequestParam("memberNo") long memberNo, Model model);

	public String memberModify(MemberManagerDto memberManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);

}
