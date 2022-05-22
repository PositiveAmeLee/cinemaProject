package com.cinema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieDto;
import com.cinema.service.MovieService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/*
 * 메인페이지 입니다.
 * */
@Controller
@Log4j
@AllArgsConstructor  //생성자 주입을 위해서 사용했습니다.
public class HomeController {

//	영화 정보를 웹레이어에 제공하기위해서 movieService가 필요합니다.
	private MovieService movieService;

// HomeController 기본 메소드를 그대로 재활용했습니다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("move to home..........");
// 메인화면에 영화리스트를 보여주기 위해 MovieVO를 List에 담아서 model에 추가했습니다.
		List<MovieDto.MovieResultDto> movieList = movieService.movieList();
		model.addAttribute("list", movieList);
// 메인화면 최상단에 보여주는 메인영화는 가지고 있는 영화 중 랜덤으로 뽑기위해 Math.random()을 이용했습니다.
		int main = (int) (Math.random() * movieList.size());
		model.addAttribute("main", movieList.get(main));
// 선택된 메인영화를 메인으로 선택하여 movieVO를 "main"으로 추가하여 model에 담아 웹레이어로 전송합니다.
		return "main/home";
	}

}
