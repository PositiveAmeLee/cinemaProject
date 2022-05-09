package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;

public interface MemberManagerController {
	
	public void memberList(Criteria cri, Model model);
	
	public void memberDetail(long memberNo, Model model);

	public String memberDetailModify(MemberManagerDto memberManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);

	public String memberSearch(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	
}
