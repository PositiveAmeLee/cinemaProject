package com.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.MemberDto;
import com.cinema.domain.MovieDto;
import com.cinema.domain.ReservationDto;
import com.cinema.service.MovieService;
import com.cinema.service.ReservationService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor//생성자주입
@RequestMapping("/ticket/")
public class ReservationController {
	//@Autowired 생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private ReservationService reservationService;
	//영화리스트를 가져오기 위해 사용
	private MovieService movieService;
	
	//티켓예매 페이지 이동
	@GetMapping("/ticketForm")
	public void ticketForm(Model model) {
		model.addAttribute("list",movieService.movieList());
	}
	
	/*
	 * parameter
	 * ReservactionDto.ReservationCreateDto의 필드값
	 * */
	@PostMapping("/ticketSeat")
	public void tickSeat(ReservationDto.ReservationCreateDto createDto,Model model) {
		model.addAttribute("reserve", createDto);
	}
	
	/*
	 * parameter
	 * ReservationDto.ReservationCreateDto의 필드값
	 * */
	@PostMapping(value="/ticketing")
	public String ticketing(ReservationDto.ReservationCreateDto createDto,Model model,RedirectAttributes rttr) {
		int result = reservationService.ticketing(createDto);
		if(result==1) {
			rttr.addFlashAttribute("message", "예매에 성공했습니다. 예매목록으로 이동합니다.");
			return "redirect:/ticket/Allticket";			
		}else {
			rttr.addFlashAttribute("message","예매에 실패했습니다. 잠시 후 다시 시도해주십시오.");
			return "redirect:/ticketForm";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getJson", method= {RequestMethod.POST,RequestMethod.GET},produces="text/plain;charset=UTF-8")
	public String getJson() {
		String gson = "";
		List<MovieDto.MovieResultDto> list = movieService.movieList();
		gson = new Gson().toJson(list);
		return gson;
	}
	
	/*
	 * parameter
	 * 세션에서 member의 primary key를 가져오기 위해 request
	 * */
    @GetMapping("/Allticket")
	public String getAll(HttpServletRequest request,Model model,RedirectAttributes rttr) {
    	HttpSession session = request.getSession();
    	MemberDto.MemberLoginResponseDto responseDto =(MemberDto.MemberLoginResponseDto)session.getAttribute("response");
    	Long memberNO = responseDto.getMemberNo();
		List<ReservationDto.ReservationResultDto> allTicketLists = reservationService.getAll(memberNO);
		model.addAttribute("ticketList",allTicketLists);
		rttr.addFlashAttribute("meesage", "예약이 완료되었습니다.");
		return "/ticket/ticketList";
	}
	
	/*
	 * parameter
	 * 삭제처리를위해 reservation 영속계층의 primarykey (long ticketNo)
	 * 삭제는 soft delete를 이용합니다.
	 * */
    @PostMapping(value="/cancle")
	public String cancel(Long ticketNO,RedirectAttributes rttr) {
		int result = reservationService.cancel(ticketNO);
		rttr.addFlashAttribute("message","예매가 취소되었습니다.");
		return "redirect:/ticket/Allticket";
	}
}
