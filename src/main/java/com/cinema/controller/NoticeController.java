package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.Criteria;
import com.cinema.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/notice/")
@RequiredArgsConstructor//생성자 주입
public class NoticeController {

	private final NoticeService noticeService;
	
	/*
	 * parameter
	 * Criteria의 필드값
	 * int pageNum
	 * int amount
	 * String type
	 * String keyword
	 * (검색 및 페이징처리에 필요한 값입니다.)
	 * */
	@GetMapping("/list")
	public void getList(Model model,Criteria cri) {
		model.addAttribute("noticelist", noticeService.getList(cri));
	}
	
	/*
	 * parameter
	 * notice 조회를 위한 primary key(long noticeNo)
	 * 받는 정보는 list의 값과 동일하게 NoticeDto.NoticeResultDto 내부클래스로 받습니다.
	 * */
	@GetMapping("/notice")
	public void get(long noticeNo,Model model) {
		
	}
	
}
