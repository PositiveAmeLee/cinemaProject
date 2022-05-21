package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerResultMap;

public interface ReservationManagerController {

	public void reservationManagerList(Model model, Criteria cri);

	public void reservationManagerGet(@RequestParam("resNo") long resNo, Model model);

	public String reservationManagerModify(ReservationManagerResultMap reservationManagerResultMap,
			@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);

	public String reservationManagerDelete(@RequestParam("resNo") long resNo, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr);

}
