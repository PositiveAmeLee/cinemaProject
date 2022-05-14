package com.cinema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.domain.MovieVO;
import com.cinema.service.MovieService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	
	private MovieService movieService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		log.info("main page has loaded..........");
		List<MovieVO> movieList = movieService.movieList();
		model.addAttribute("list",movieList);
		log.info("movie list has loaded...........");
		int main = (int) (Math.random()*movieList.size());
		model.addAttribute("main", movieList.get(main));
		log.info("movie main has set.....movie: "+movieList.get(main).getMovie_title());
		return "main/home";
	}
	
}
