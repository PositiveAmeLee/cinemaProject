
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
import com.cinema.service.CommentManagerService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/commentManager/*")
@AllArgsConstructor
@NoArgsConstructor
public class CommentManagerControllerImpl implements CommentManagerController {

	@Autowired(required = false)
	private CommentManagerService commentManagerService;

	@Override
	@GetMapping("/list")
	public void CommentManagerList(Model model, Criteria cri) {
		model.addAttribute("commentList", commentManagerService.commentManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, commentManagerService.commentManagerGetTotalCount()));
	}

	@Override
	@PostMapping("/delete")
	public String CommentManagerDelete(@RequestParam("commentNo") long commentNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (commentManagerService.commentManagerDelete(commentNo)) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/commentManager/list";
	}

}
