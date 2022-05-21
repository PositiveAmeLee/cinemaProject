package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.service.CommentManagerService;
import com.cinema.service.CustomerManagerService;
import com.cinema.service.MemberManagerService;
import com.cinema.service.MovieManagerService;
import com.cinema.service.NoticeManagerService;
import com.cinema.service.ReservationManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class Main {
	
	MovieManagerService movieManagerService;
	
	MemberManagerService memberManagerService;
	
	ReservationManagerService reservationManagerService;
	
	CommentManagerService commentManagerService;
	
	NoticeManagerService noticeManagerService;
	
	CustomerManagerService customerManagerService;
	
	
	@GetMapping("/manager")
	public String main(Model model, Criteria cri) {
		model.addAttribute("movie", new PageDto(cri, movieManagerService.movieManagerGetTotalCount()));
		model.addAttribute("member", new PageDto(cri, memberManagerService.memberGetTotal()));
		model.addAttribute("reservation", new PageDto(cri, reservationManagerService.reservationManagerGetTotalCount()));
		model.addAttribute("comment", new PageDto(cri, commentManagerService.commentManagerGetTotalCount()));
		model.addAttribute("notice", new PageDto(cri, noticeManagerService.noticeManagerGetTotalCount()));
		model.addAttribute("question", new PageDto(cri, customerManagerService.questionManagerGetTotalCount()));
		return "main";
	}
}
