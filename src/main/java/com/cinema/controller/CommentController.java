package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.CommentDto;
import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.service.CommentService;
import com.cinema.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor //생성자 주입
@RequestMapping("/replies/")
public class CommentController {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final CommentService commentService;
	//영화리스트를 불러오기위해 movieService를 주입합니다.
	private final MovieService movieService;
	
	/*
	 * parameter
	 * Criteria의 필드값
	 * int pageNum
	 * int amount
	 * String type
	 * String keyword
	 * (검색 및 페이징처리에 필요한 값입니다.)
	 * */
	@GetMapping("/reviewMain")
	public void moveToReview(Model model) {
		//movieService에서 List<MovieDto.Movie
		model.addAttribute("list",movieService.movieList());
	}
	
	/*
	 * parameter
	 * Criteria의 필드값
	 * int pageNum
	 * int amount
	 * String type
	 * String keyword
	 * (검색 및 페이징처리에 필요한 값입니다.)
	 * */
	@GetMapping("/reply")
	public void moveToReply(Long movieNO,Model model,Criteria cri) {
		log.info("move to Reply..........movieNO: "+movieNO);
		model.addAttribute("list",movieService.movieList());
		model.addAttribute("movie",movieService.movieInfo(movieNO));
		//commentService에서 List<CommentDto.CommentResultDto>를 가져와 모델에 추가합니다.
		model.addAttribute("replyList",commentService.getListFindByMovieNO(movieNO,cri));
		//페이지정보 저장을 위해 pageMaker를 생성해 모델에 추가합니다.
		model.addAttribute("pageMaker", new PageDto(cri, commentService.commentGetTotalCount()));
	}
	
	/*
	 * parameter
	 * comment 조회를 위한 primary key(Long commnetNO)
	 * */
    @GetMapping("/get")
	public void get(Long commentNO,Model model) {
		//CommnetService에서 CommnetDto.CommnetResultDto를 가져와 모델에 추가합니다.
		CommentDto.CommentResultDto commnetDto = commentService.get(commentNO);
		model.addAttribute("comment", commnetDto);
	}
    
	/*
	 * parameter
	 * comment 등록을 위한 commentDto.CommentCreateDto의 필드값
	 * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
	 * */
    @PostMapping("/writeReview")	
	public String create(CommentDto.CommentCreateDto createDto){
		int result = commentService.register(createDto);
		return "redirect:/replies/reply?movieNO="+createDto.getMovieNo();
	}
    
    /*
     * parameter
     * comment 수정을 위한 commentDto.CommentUpdateDto의 필드값
     * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
     * 삭제 이후 페이지 이동처리를 위한 movieNO
     * */
    @PostMapping("/update")
	public String modify(CommentDto.CommentUpdateDto updateDto,Long movieNO){
		int result = commentService.modify(updateDto);
		return "redirect:/replies/reply?movieNO="+movieNO;
	}

    /*
	 * parameter
	 * comment 영속계층의 primary key (Long commnetNO)
	 * (삭제 처리를 위해 필요한 값입니다.)
	 * 삭제 이후 페이지 이동처리를 위한 movieNO
	 */
    @PostMapping("/delete")
	public String remove(Long commentNO,Long movieNO){
		log.info("remove reply..........replyNO: "+commentNO);
		int result = commentService.remove(commentNO);
		return "redirect:/replies/reply?movieNO="+movieNO;
	}
}
