
package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void movieManagerList(Model model, Criteria cri) {
		model.addAttribute("movieList", movieManagerService.movieManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, movieManagerService.movieManagerGetTotalCount()));
	}

	@Override
	@GetMapping({ "/movie", "/modify" })
	public void movieManagerGet(@RequestParam("movieNo") long movieNo, Model model) {
		model.addAttribute("movie", movieManagerService.movieManagerGet(movieNo));
	}

	@Override
	@GetMapping("/register")
	public void movieManagerRegister() {

	}

	@Override
	@PostMapping("/register")
	public String movieManagerRegister(MovieManagerDto movieManagerDto, RedirectAttributes rttr) {
		boolean result = movieManagerService.movieManagerRegister(movieManagerDto);
		if (result == true) {
			rttr.addFlashAttribute("result", movieManagerDto.getMovieNo());
		} else
			rttr.addFlashAttribute("result", "fail");
		return "redirect:/movieManager/list";
	}

	@Override
	@PostMapping("/modify")
	public String movieManagerModify(MovieManagerDto movieManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = movieManagerService.movieManagerModify(movieManagerDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/movieManager/list";
	}

	@Override
	@PostMapping("/delete")
	public String movieManagerDelete(@RequestParam("movieNo") long movieNo, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		boolean result = movieManagerService.movieManagerDelete(movieNo);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/movieManager/list";
	}

}
