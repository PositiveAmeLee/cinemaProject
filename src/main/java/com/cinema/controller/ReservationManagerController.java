
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
import com.cinema.domain.PageDto;
import com.cinema.domain.ReservationManagerResultMap;
import com.cinema.service.ReservationManagerService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/reservationManager/*")
@RequiredArgsConstructor
public class ReservationManagerController {

	@Autowired
	private final ReservationManagerService reservationManagerService;

	@GetMapping("/list")
	public void reservationManagerList(Model model, Criteria cri) {
		model.addAttribute("reservationList", reservationManagerService.reservationManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, reservationManagerService.reservationManagerGetTotalCount()));
	}

	@GetMapping({ "/reservation", "modify" })
	public void reservationManagerGet(@RequestParam("resNo") long resNo, Model model) {
		model.addAttribute("reservation", reservationManagerService.reservationManagerGet(resNo));
	}

	@PostMapping("/modify")
	public String reservationManagerModify(ReservationManagerResultMap reservationManagerResultMap,
			@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (reservationManagerService.reservationManagerManagerModify(reservationManagerResultMap)) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/reservationManager/list";
	}

	@PostMapping("/delete")
	public String reservationManagerDelete(@RequestParam("resNo") long resNo, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		boolean result = reservationManagerService.reservationManagerManagerDelete(resNo);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/reservationManager/list";
	}

}
