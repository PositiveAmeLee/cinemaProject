package com.cinema.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.ReplyVO;
import com.cinema.service.MovieService;
import com.cinema.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {

	private ReplyService replyService;
	
	private MovieService movieService;
	
	@GetMapping("/reviewMain")
	public void moveToReview(Model model) {
		log.info("move to reviewMain..........");
		model.addAttribute("list",movieService.movieList());
		log.info("movie list has loaded...........");
	}
	
	
	@GetMapping("/reply")
	public void moveToReply(Long movieNO,Model model) {
		log.info("move to Reply..........movieNO: "+movieNO);
		model.addAttribute("list",movieService.movieList());
		model.addAttribute("movie",movieService.movieInfo(movieNO));
		model.addAttribute("replyList",replyService.getListFindByMovieNO(movieNO));
	}
	
	
    @GetMapping("/get")
	public void get(Long replyNO,Model model) {
		log.info("get Reply..........replyNO: "+replyNO);
		ReplyVO replyVO = replyService.get(replyNO);
		log.info("get result: "+replyVO);
		model.addAttribute("reply", replyVO);
	}
	
// @GetMapping("/getListFindByMemberNO/{memberNO}")
	public ResponseEntity<List<ReplyVO>> getListFindByMemberNO(@PathVariable("memberNO")Long memberNO){
		log.info("get ReplyList where memberNO: "+memberNO);
		return new ResponseEntity<>(replyService.getListFindByMemberNO(memberNO),HttpStatus.OK);
	}
	
    @PostMapping("/writeReview")	
	public String create(ReplyVO replyVO){
		log.info("create Reply..........replyVO: "+replyVO);
		int result = replyService.register(replyVO);
		log.info("create result: "+result);
		return "redirect:/replies/reply?movieNO="+replyVO.getMovieNO();
	}
	
    @PostMapping("/update")
	public String modify(ReplyVO replyVO){
		log.info("modify Reply..........replyNO: "+replyVO.getReplyNO());
		int result = replyService.modify(replyVO);
		log.info("modify result: "+result);
		return "redirect:/replies/reply?movieNO="+replyVO.getMovieNO();
	}

    @PostMapping("/delete")
	public String remove(Long replyNO,Long movieNO){
		log.info("remove reply..........replyNO: "+replyNO);
		int result = replyService.remove(replyNO);
		return "redirect:/replies/reply?movieNO="+movieNO;
	}
}
