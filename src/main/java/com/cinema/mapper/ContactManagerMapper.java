package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.AnswerDto;
import com.cinema.domain.Criteria;
import com.cinema.domain.QuestionDto;

public interface ContactManagerMapper {
	
	public List<QuestionDto.QuestionResultDto> questionManagerList(Criteria cri);
	
//	public List<AnswerDto> answerManagerList(Criteria cri);
	
//	public int answerManagerGetTotalCount();
	
	public int questionManagerGetTotalCount();
	
	public QuestionDto.QuestionResultDto questionManagerGet(long questionNo);
	
//	public List<AnswerDto> answerManagerGet(long answerNo);
//
//	public boolean answerManagerRegister(AnswerDto answerDto);
	
}