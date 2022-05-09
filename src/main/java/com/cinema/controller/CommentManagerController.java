package com.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;

public interface CommentManagerController {

	public void memberCommentList(long memberNo, Model model, Criteria cri);

	public void memberCommentDetail(long commentNo, Model model);

	public String CommentDelete(long commentNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);

	public String CommentSearch(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
 
}
