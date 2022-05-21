package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.AnswerDto;
import com.cinema.domain.Criteria;
import com.cinema.domain.QuestionDto;

public interface CustomerManagerMapper {
	
	public List<QuestionDto> questionManagerList(Criteria cri);
	
	public List<AnswerDto> answerManagerList(Criteria cri);
	
	public int answerManagerGetTotalCount();
	
	public int questionManagerGetTotalCount();
	
	public List<QuestionDto> questionManagerGet(long questionNo);
	
	public List<AnswerDto> answerManagerGet(long answerNo);

	public boolean answerManagerRegister(AnswerDto answerDto);
	
}