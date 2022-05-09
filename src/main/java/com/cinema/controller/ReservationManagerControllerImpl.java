package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.domain.ReservationManagerDto;
import com.cinema.service.ReservationManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/reservationManager/*")
@AllArgsConstructor
public class ReservationManagerControllerImpl implements ReservationManagerController {

	@Autowired
	ReservationManagerService reservationManagerService;

	@Override
	@GetMapping("/list")
	public void reservationList(Model model, Criteria cri) {
		model.addAttribute("list", reservationManagerService.reservationList());
		model.addAttribute("pageMaker", new PageDto(cri, reservationManagerService.reservationGetTotalCount()));
	}

	@Override
	@GetMapping("/reservation")
	public void reservationDetail(long resNo, Model model, Criteria cri) {
		model.addAttribute("comment", reservationManagerService.reservationDetail(resNo));
	}

	@Override
	@PostMapping("/modify")
	public String reservationDetailModify(ReservationManagerDto reservationManagerDto, Criteria cri,
			RedirectAttributes rttr) {
		if (reservationManagerService.reservationDetailModify(reservationManagerDto)) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return null;
	}

	@Override
	@PostMapping("/delete")
	public String reservationDelete(long resNo, Criteria cri, RedirectAttributes rttr) {
		return null;
	}

	@Override
	@GetMapping("/search")
	public String reservationSearch(Criteria cri, RedirectAttributes rttr) {
		ReservationManagerDto reservationManagerDto;
		reservationManagerDto = (ReservationManagerDto) reservationManagerService.reservationManagerSearch(cri);
		if (reservationManagerDto != null) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("search", reservationManagerDto);
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return null;
	}

}
