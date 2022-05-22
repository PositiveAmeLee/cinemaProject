package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.QuestionDto;
import com.cinema.service.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor//생성자 주입
@RequestMapping(value = "/mypage")
public class ConntactController {
	//@Autowired 생략 = 스프링 4.3 이후 지원하는 묵시적 자동 주입
	private final ContactService mypageService;
	
	//마이페이지 이동
	@GetMapping("/mypage")
	public void mypage() {
	}
	
	/*
	 * parameter
	 * QuestionDto.QuestionCreateDto 의 필드값
	 * */
	@PostMapping("/contact")
	public String createContact(QuestionDto.QuestionCreateDto createDto) {
		int result = mypageService.create(createDto);
		return "redirect:/";
	}
}
