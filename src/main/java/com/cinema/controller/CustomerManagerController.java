package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.AnswerDto;
import com.cinema.domain.Criteria;

public interface CustomerManagerController {

	public void questionManagerList(Model model, Criteria cri);

	public void answerManagerList(Model model, Criteria cri);

	public void questionManagerGet(@RequestParam("questionNo") long questionNo, Model model);

	public void answerManagerGet(@RequestParam("answerNo") long answerNo, Model model);

	public String answerManagerRegister(AnswerDto answerDto, RedirectAttributes rttr);

}
