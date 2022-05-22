
package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieDto;
import com.cinema.domain.PageDto;
import com.cinema.service.MovieManagerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/movieManager/*")
@RequiredArgsConstructor // 생성자주입
public class MovieManagerController  {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final MovieManagerService movieManagerService;

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
	public void movieManagerList(Model model, Criteria cri) {
		model.addAttribute("movieList", movieManagerService.movieManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, movieManagerService.movieManagerGetTotalCount()));
	}

	/*
	 * parameter
	 * movie 영속계층의 primary key(Long movieNO)
	 * */
	@GetMapping({ "/movie", "/modify" })
	public void movieManagerGet(@RequestParam("movieNo") long movieNo, Model model) {
		model.addAttribute("movie", movieManagerService.movieManagerGet(movieNo));
	}

	/*
	 * 영화등록화면으로 이동
	 * */
	@GetMapping("/register")
	public void movieManagerRegister() {

	}
	/*
	 * parameter
	 * MovieDto.MovieCreateDto의 필드값
	 * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
	 * */
	@PostMapping("/register")
	public String movieManagerRegister(MovieDto.MovieCreateDto createDto, RedirectAttributes rttr) {
		boolean result = movieManagerService.movieManagerRegister(createDto);
		if (result == true) {
			rttr.addFlashAttribute("result", createDto.getMovieNo());
		} else
			rttr.addFlashAttribute("result", "fail");
		return "redirect:/movieManager/list";
	}

	/*
	 * parameter
	 * MovieDto.MovieModifyDto의 필드값
	 * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
	 * Criteria의 필드값
     * (수정 이후 페이징처리에 필요한 값입니다.)
	 * */
	@PostMapping("/modify")
	public String movieManagerModify(MovieDto.MovieModifyDto modifyDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = movieManagerService.movieManagerModify(modifyDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/movieManager/list";
	}

	/*
	 * parameter
	 * movie영속계층의 primary key (Long movieNo)
	 * (삭제 처리를 위해 필요한 값입니다.)
	 * Criteria의 필드값
	 * (삭제 이후 페이징처리에 필요한 값입니다.)
	 * 삭제는 soft delete를 사용합니다.
	 * */
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
