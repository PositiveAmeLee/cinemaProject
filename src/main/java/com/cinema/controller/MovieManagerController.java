package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieManagerDto;

public interface MovieManagerController {

	public void movieList(Model model, Criteria cri);
	
	public String movieRegister(MovieManagerDto movieManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	
	public String movieDetail(long movieNo, Model model);
	
	public String movieDetailModify(MovieManagerDto movieManagerDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr );
	
	public String movieDelete(long movieNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	
	public String movieSearch(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	
}
