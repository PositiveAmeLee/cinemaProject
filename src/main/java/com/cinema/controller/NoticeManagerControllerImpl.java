package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto;
import com.cinema.domain.PageDto;
import com.cinema.service.NoticeManagerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/noticeManager/*")
@RequiredArgsConstructor //생성자 주입
public class NoticeManagerControllerImpl{
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	NoticeManagerService noticeManagerService;
	
	/*
	 * 등록페이지로 이동
	 * */
	@GetMapping("/register")
	public void noticeRegister() {
	}

	/*
	 * parameter
	 * NoticeDto.NoticeCreateDto의 필드 값
	 * */
	@PostMapping("/register")
	public String noticeManagerRegister(NoticeDto.NoticeCreateDto createDto, RedirectAttributes rttr) {
		boolean result = noticeManagerService.noticeManagerRegister(createDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		return "redirect:/noticeManager/list";
	}

	/*
	 * parameter
	 * Criteria의 필드값
	 * int pageNum
	 * int amount
	 * String type
	 * String keyword
	 * (검색 및 페이징처리에 필요한 값입니다.)
	 * */
	@GetMapping("/list")
	public void noticeManagerList(Model model, Criteria cri) {
		model.addAttribute("noticeList", noticeManagerService.noticeManagerList(cri));
		model.addAttribute("pageMaker", new PageDto(cri,noticeManagerService.noticeManagerGetTotalCount()));
	}

	/*
	 * parameter
	 * notice 조회를 위한 primary key(long noticeNo)
	 * 받는 정보는 list의 값과 동일하게 NoticeDto.NoticeResultDto 내부클래스로 받습니다.
	 * */
	@GetMapping({"/notice","/modify"})
	public void noticeManagerGet(long noticeNo, Model model) {
		model.addAttribute("notice", noticeManagerService.noticeManagerGet(noticeNo));
	}

	/*
	 * parameter
	 * NoticeDto.NoticeModifyDto의 필드값
     * Criteria 의 필드값
     * 필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
     * Cri의 필드값은 수정 후 페이징처리에 사용됩니다.
	 * */
	@PostMapping("/modify")
	public String noticeManagerModify(NoticeDto.NoticeModifyDto modifyDto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = noticeManagerService.noticeManagerModify(modifyDto);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/noticeManager/list";
	}

	@PostMapping("/delete")
	public String noticeManagerDelete(@RequestParam("noticeNo")long noticeNo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boolean result = noticeManagerService.noticeManagerDelete(noticeNo);
		if (result == true) {
			rttr.addFlashAttribute("result", "success");
		} else
			rttr.addFlashAttribute("result", "fail");
		rttr.addAttribute("p", cri.getPageNum());
		return "redirect:/noticeManager/list";
	}

}
