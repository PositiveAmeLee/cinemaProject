package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/movie/*")
@RequiredArgsConstructor // 생성자주입
public class MovieController {
	// @Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final MovieService movieService;
	
}
