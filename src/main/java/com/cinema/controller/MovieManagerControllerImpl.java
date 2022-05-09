package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieManagerDto;
import com.cinema.domain.PageDto;
import com.cinema.service.MovieManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/movieManager/*")
@AllArgsConstructor
public class MovieManagerControllerImpl implements MovieManagerController {

	@Autowired
	MovieManagerService movieManagerService;
	
	@Override
	@GetMapping("/list")
	public void movieList(Model model, Criteria cri) {
		model.addAttribute("list", movieManagerService.loadMovieList());
		model.addAttribute("pageMaker", new PageDto(cri,movieManagerService.movieGetTotalCount()));
	}

	@Override
	@PostMapping("/register")
	public String movieRegister(MovieManagerDto movieManagerDto, Criteria cri, RedirectAttributes rttr) {
		boolean result = movieManagerService.movieRegister(movieManagerDto);
		if(result==true) {
			rttr.addFlashAttribute("result", "success");
		} else rttr.addFlashAttribute("result", "fail");
		return null;
	}

	@Override
	@GetMapping("/movie")
	public String movieDetail(long movieNo, Model model) {
		model.addAttribute("movie", movieManagerService.deleteMovie(movieNo));
		return null;
	}

	@Override
	@GetMapping("/modify")
	public String movieDetailModify(MovieManagerDto movieManagerDto, Criteria cri, RedirectAttributes rttr) {
		boolean result = movieManagerService.modifyMovieDetail(movieManagerDto);
		if(result==true) {
			rttr.addFlashAttribute("result", "success");
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return null;
	}

	@Override
	@PostMapping("/delete")
	public String movieDelete(long movieNo, Criteria cri, RedirectAttributes rttr) {
		boolean result = movieManagerService.deleteMovie(movieNo);
		if(result==true) {
			rttr.addFlashAttribute("result", "success");
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return null;
	}

	@Override
	@GetMapping("/search")
	public String movieSearch(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		List<MovieManagerDto> list = movieManagerService.searchMovie(cri);
		if(list!=null) {
			rttr.addFlashAttribute("result", "success");
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		return null;
	}

}
