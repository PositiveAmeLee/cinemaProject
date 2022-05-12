package com.cinema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.TicketVO;
import com.cinema.service.TicketService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/ticket/")
public class TicketController {

	private TicketService ticketService;
	
	// 
	@GetMapping("/ticketForm")
	public void ticketForm() {
		log.info("move to ticketForm..........");
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
	
// @PostMapping()
	public String ticketing(List<TicketVO> tickets,RedirectAttributes rttr) {
		for(int i = 0 ; i<tickets.size();i++) {
			int result = ticketService.ticketing(tickets.get(i));
			log.info("ticketing..........ticketNO: "+tickets.get(i).getTicketNO());
		}//end for
		
		rttr.addAttribute("result","예매가 완료되었습니다.");

		return ""; //getAll 메소드 호출하도록 만들기.
	}
	
// @PostMapping()
	public String cancel(Long ticketNO,RedirectAttributes rttr) {
		log.info("ticketCancel..........: "+ticketNO);
		int result = ticketService.cancel(ticketNO);
		rttr.addAttribute("result","예매가 취소되었습니다.");
		return ""; // getAll 메소드 호출하도록 만들기.
	}
}
