package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private final ContactService contactService;
	
	//마이페이지 이동
	@GetMapping("/mypage")
	public void mypage() {
	}
	
	/*
	 * parameter
	 * QuestionDto.QuestionCreateDto 의 필드값
	 * */
	@PostMapping("/contact")
	public String createContact(QuestionDto.QuestionCreateDto createDto,RedirectAttributes rttr) {
		int result = contactService.create(createDto);
		if(result==1) {
			rttr.addFlashAttribute("message", "문의가 정상적으로 처리되었습니다.감사합니다.");
		}else {
			rttr.addFlashAttribute("message", "문의가 정상적으로 처리되지않았습니다. 고객센터로 전화문의부탁드립니다. 불편을 드려서 죄송합니다.");
		}
		return "redirect:/";
	}
}
