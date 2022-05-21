package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.AnswerDto;
import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.service.CustomerManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/customerManager/*")
@AllArgsConstructor
public class CustomerManagerControllerImpl implements CustomerManagerController {

	private CustomerManagerService customerManagerService;
	
	@Override
	@GetMapping("/questionList")
	public void questionManagerList(Model model, Criteria cri) {
		model.addAttribute("questionList", customerManagerService.questionManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri,customerManagerService.questionManagerGetTotalCount()));
	}

	@Override
	@GetMapping("/answerList")
	public void answerManagerList(Model model, Criteria cri) {
		model.addAttribute("answerList", customerManagerService.answerManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri,customerManagerService.answerManagerGetTotalCount()));
	}

	@Override
	@GetMapping({"/question","/register"})
	public void questionManagerGet(long questionNo, Model model) {
		model.addAttribute("question", customerManagerService.questionManagerGet(questionNo));
	}

	@Override
	@GetMapping("/answer")
	public void answerManagerGet(long answerNo, Model model) {
		model.addAttribute("answer", customerManagerService.answerManagerGet(answerNo));
	}

	@Override
	@PostMapping("register")
	public String answerManagerRegister(AnswerDto answerDto, RedirectAttributes rttr) {
		boolean result = customerManagerService.answerManagerRegister(answerDto);
		if (result == true) {
			rttr.addFlashAttribute("result", answerDto.getAnswerNo());
		} else
			rttr.addFlashAttribute("result", "fail");
		return "redirect:/customerManager/answerList";
	}

}
