package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.ContactVO;
import com.cinema.service.MypageService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping(value = "/mypage")
public class MypageController {

	private MypageService mypageService;
	
	@GetMapping("/mypage")
	public void mypage() {
		log.info("move to mypage..........");
	}
	
	@PostMapping("/contact")
	public String createContact(ContactVO contactVO) {
		int result = mypageService.create(contactVO);
		return "redirect:/";
	}
}
