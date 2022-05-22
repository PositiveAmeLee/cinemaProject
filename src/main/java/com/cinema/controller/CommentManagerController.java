
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
import com.cinema.domain.PageDto;
import com.cinema.service.CommentManagerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/commentManager/*")
@RequiredArgsConstructor // 생성자 주입 
public class CommentManagerController {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final CommentManagerService commentManagerService;

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
	public void CommentManagerList(Model model, Criteria cri) {
		//commentManagerService에서 List<CommentDto.CommentResultDto>를 가져와 모델에 추가합니다.
		//필요이상의 파라미터를 받는것을 방지하기위해 내부클래스를 구현했습니다.
		model.addAttribute("commentList", commentManagerService.commentManagerList(cri));
		//페이지정보 저장을 위해 pageMaker를 생성해 모델에 추가합니다.
		model.addAttribute("pageMaker", new PageDto(cri, commentManagerService.commentManagerGetTotalCount()));
	}

	/*
	 * parameter
	 * comment 영속계층의 primary key (Long commnetNO)
	 * (삭제 처리를 위해 필요한 값입니다.)
	 * Criteria의 필드값
	 * (삭제 이후 페이징처리에 필요한 값입니다.)
	 * 삭제는 soft delete를 사용합니다.
	 * */
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
