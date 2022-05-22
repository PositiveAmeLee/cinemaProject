package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.service.CommentManagerService;
import com.cinema.service.ContactManagerService;
import com.cinema.service.MemberManagerService;
import com.cinema.service.MovieManagerService;
import com.cinema.service.NoticeManagerService;
import com.cinema.service.ReservationManagerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor//생성자주입
public class Main {
	// @Autowired 생략 = 스프링 4.3 이후 지원하는 묵시적 자동 주입
	private final MovieManagerService movieManagerService;
	
	private final MemberManagerService memberManagerService;
	
	private final ReservationManagerService reservationManagerService;
	
	private final CommentManagerService commentManagerService;
	
	private final NoticeManagerService noticeManagerService;
	
	private final ContactManagerService contactManagerService;
	
	
	@GetMapping("/manager")
	public String main(Model model, Criteria cri) {
		model.addAttribute("movie", new PageDto(cri, movieManagerService.movieManagerGetTotalCount()));
		model.addAttribute("member", new PageDto(cri, memberManagerService.memberGetTotal()));
		model.addAttribute("reservation", new PageDto(cri, reservationManagerService.reservationManagerGetTotalCount()));
		model.addAttribute("comment", new PageDto(cri, commentManagerService.commentManagerGetTotalCount()));
		model.addAttribute("notice", new PageDto(cri, noticeManagerService.noticeManagerGetTotalCount()));
		model.addAttribute("question", new PageDto(cri, contactManagerService.questionManagerGetTotalCount()));
		return "main";
	}
}
