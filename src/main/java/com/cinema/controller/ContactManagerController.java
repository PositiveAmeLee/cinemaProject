package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.domain.Criteria;
import com.cinema.domain.PageDto;
import com.cinema.service.ContactManagerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/customerManager/*")
@RequiredArgsConstructor //생성자 주입
public class ContactManagerController {
	//@Autowired 생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private final ContactManagerService contactManagerService;

	/*
	 * parameter
	 * Criteria 의 필드값
	 * 페이징처리를 위해 사용합니다.
	 * */
	@GetMapping("/questionList")
	public void questionManagerList(Model model, Criteria cri) {
		model.addAttribute("questionList", contactManagerService.questionManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri, contactManagerService.questionManagerGetTotalCount()));
	}
//
//	@GetMapping("/answerList")
//	public void answerManagerList(Model model, Criteria cri) {
//		model.addAttribute("answerList", customerManagerService.answerManagerList(cri));
//		model.addAttribute("pageMaker", new PageDto(cri, customerManagerService.answerManagerGetTotalCount()));
//	}
	
	/*
	 * question의 조회를 위한 primary key(long questionNo)
	 * */
	@GetMapping({ "/question", "/register" })
	public void questionManagerGet(long questionNo, Model model) {
		model.addAttribute("question", contactManagerService.questionManagerGet(questionNo));
	}

//	@GetMapping("/answer")
//	public void answerManagerGet(long answerNo, Model model) {
//		model.addAttribute("answer", customerManagerService.answerManagerGet(answerNo));
//	}

//	@PostMapping("register")
//	public String answerManagerRegister(AnswerDto answerDto, RedirectAttributes rttr) {
//		boolean result = customerManagerService.answerManagerRegister(answerDto);
//		if (result == true) {
//			rttr.addFlashAttribute("result", answerDto.getAnswerNo());
//		} else
//			rttr.addFlashAttribute("result", "fail");
//		return "redirect:/customerManager/answerList";
//	}

}
