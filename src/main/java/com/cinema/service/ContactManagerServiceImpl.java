package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.QuestionDto;
import com.cinema.mapper.ContactManagerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor//생성자 주입
public class ContactManagerServiceImpl implements ContactManagerService {
	//@Autowired생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private ContactManagerMapper contactManagerMapper;

	@Override
	public List<QuestionDto.QuestionResultDto> questionManagerList(Criteria cri){
		return contactManagerMapper.questionManagerList(cri);
	}
//	@Override
//	public List<AnswerDto> answerManagerList(Criteria cri){
//		return contactManagerMapper.answerManagerList(cri);
//	}
	@Override
	public int questionManagerGetTotalCount() {
		return contactManagerMapper.questionManagerGetTotalCount();
	}
//	@Override
//	public int answerManagerGetTotalCount() {
//		return contactManagerMapper.answerManagerGetTotalCount();
//	}
	@Override
	public QuestionDto.QuestionResultDto questionManagerGet(long questionNo){
		return contactManagerMapper.questionManagerGet(questionNo);
	}
//	@Override
//	public List<AnswerDto> answerManagerGet(long answerNo){
//		return contactManagerMapper.answerManagerGet(answerNo);
//	}
//	@Override
//	public boolean answerManagerRegister(AnswerDto answerDto) {
//		return contactManagerMapper.answerManagerRegister(answerDto);
//	}

}
