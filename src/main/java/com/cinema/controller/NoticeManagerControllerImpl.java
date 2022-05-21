package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeManagerDto;
import com.cinema.domain.PageDto;
import com.cinema.service.NoticeManagerService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/noticeManager/*")
public class NoticeManagerControllerImpl implements NoticeManagerController {

	@Autowired
	NoticeManagerService noticeManagerService;
	
	@Override
	@GetMapping("/register")
	public void noticeRegister() {
		
	}

	@Override
	@PostMapping("/register")
	public String noticeManagerRegister(NoticeManagerDto noticeManagerDto, RedirectAttributes rttr) {
		boolean result = noticeManagerService.noticeManagerRegister(noticeManagerDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		return "redirect:/noticeManager/list";
	}

	@Override
	@GetMapping("/list")
	public void noticeManagerList(Model model, Criteria cri) {
		model.addAttribute("noticeList", noticeManagerService.noticeManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri,noticeManagerService.noticeManagerGetTotalCount()));
	}

	@Override
	@GetMapping({"/notice","/modify"})
	public void noticeManagerGet(long noticeNo, Model model) {
		model.addAttribute("notice", noticeManagerService.noticeManagerGet(noticeNo));
	}

	@Override
	@PostMapping("/modify")
	public String noticeManagerModify(NoticeManagerDto noticeManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = noticeManagerService.noticeManagerModify(noticeManagerDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/noticeManager/list";
	}

	@Override
	@PostMapping("/delete")
	public String noticeManagerDelete(@RequestParam("noticeNo")long noticeNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = noticeManagerService.noticeManagerDelete(noticeNo);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/noticeManager/list";
	}

}
