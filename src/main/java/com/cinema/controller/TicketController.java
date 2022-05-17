package com.cinema.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.MovieVO;
import com.cinema.domain.TicketVO;
import com.cinema.service.MovieService;
import com.cinema.service.TicketService;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/ticket/")
public class TicketController {

	private TicketService ticketService;
	
	private MovieService movieService;
	
	
	@GetMapping("/ticketForm")
	public void ticketForm(Model model) {
		log.info("move to ticketForm..........");
		model.addAttribute("list",movieService.movieList());
	}
	
	@PostMapping("/ticketSeat")
	public void tickSeat(@RequestParam Map <String,String> ticketMap,Model model) {
		log.info("move to ticketSeat");
		String title = ticketMap.get("title");
		TicketVO reserve = new TicketVO();
		reserve.setTitle(title);
		reserve.setRunningTime(ticketMap.get("runningTime"));
		reserve.setMovieDate(ticketMap.get("movieDate"));
		reserve.setSelectedTheater(ticketMap.get("selectedTheater"));
		model.addAttribute("reserve", reserve);
		log.info("title: "+title);
	}
	
	@ResponseBody
	@RequestMapping(value="/getJson", method= {RequestMethod.POST,RequestMethod.GET},produces="text/plain;charset=UTF-8")
	public String getJson() {
		String gson = "";
		
		List<MovieVO> list = movieService.movieList();
		gson = new Gson().toJson(list);
		log.info(gson);
		return gson;
	}
	
//	@GetMapping()
	public String get(Long ticketNO,Model model) {
		log.info("ticket get..........: "+ticketNO);
		TicketVO ticketVO = ticketService.get(ticketNO);
		model.addAttribute("ticket",ticketVO);
		log.info("ticket get result ..........: "+ticketVO);
		return "checkTicket";
	}
	
// @GetMApping()
	public String getAll(Long memberNO,Model model) {
		log.info("ticket getAll..........memberNO: "+memberNO);
		List<TicketVO> allTicketLists = ticketService.getAll(memberNO);
		model.addAttribute("tickets",allTicketLists);
		return "TicketLists";
	}
	
    @PostMapping(value="ticketing")
	public String ticketing(TicketVO ticketVO) {
		log.info("ticketing.....ticketVO: "+ticketVO);
		int result = ticketService.ticketing(ticketVO);
    	return "redirect:/";
	}
	
// @PostMapping()
	public String cancel(Long ticketNO,RedirectAttributes rttr) {
		log.info("ticketCancel..........: "+ticketNO);
		int result = ticketService.cancel(ticketNO);
		rttr.addAttribute("result","예매가 취소되었습니다.");
		return ""; // getAll 메소드 호출하도록 만들기.
	}
}
