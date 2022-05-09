package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.CommentManagerDto;
import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.service.CommentManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/commentManager/*")
@AllArgsConstructor
public class CommentManagerControllerImpl implements CommentManagerController {

	@Autowired
	CommentManagerService commentManagerService;

	@Override
	@GetMapping("/list")
	public void memberCommentList(long memberNo, Model model, Criteria cri) {
		model.addAttribute("list", commentManagerService.loadMemberCommentList(memberNo));
		model.addAttribute("pageMaker", new PageDto(cri, commentManagerService.commentGetTotalCount()));
	}

	@Override
	@GetMapping("/comment")
	public void memberCommentDetail(long commentNo, Model model) {
		model.addAttribute("comment", commentManagerService.loadMemberComentDetail(commentNo));
	}

	@Override
	@PostMapping("/delete")
	public String CommentDelete(long commentNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (commentManagerService.deleteComment(commentNo)) {
			rttr.addFlashAttribute("result", "success");
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/manager_commentlist";
	}

	@Override
	@GetMapping("/search")
	public String CommentSearch(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		CommentManagerDto commentManagerDto;
		commentManagerDto = (CommentManagerDto) commentManagerService.searchComment(cri);
		if (commentManagerDto != null) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("search", commentManagerDto);
		} else rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/manager_commentlist";
	}
}
