package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieVO;
import com.cinema.service.MovieService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/movie/*")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

//	1. 영화 전체 목록
	@GetMapping("/list")
	public void movieList(Criteria cri, Model model) {
		model.addAttribute("list", movieService.movieList());
	}

//	2. 영화 상세 정보
	@GetMapping("/info")
	public String movieInfo(long movie_no,Model model) {
		MovieVO movieVO = movieService.movieInfo(movie_no);
		model.addAttribute("movie",movieVO);
		return "";
	}

//	3. 영화 검색
//	@GetMapping("/list/{}")
	public void search(@ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("pageNum", cri.getPageNum());
		model.addAttribute("keyword", cri.getKeyword());
	}

}
