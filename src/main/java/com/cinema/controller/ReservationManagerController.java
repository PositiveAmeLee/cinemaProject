package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerDto;

public interface ReservationManagerController {
	
	public void reservationList(Model model, Criteria cri);

	public void reservationDetail(long resNo, Model model, Criteria cri);
	
	public String reservationDetailModify(ReservationManagerDto reservationManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);

	public String reservationDelete(long resNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	
	public String reservationSearch(Criteria cri, RedirectAttributes rttr);

}
