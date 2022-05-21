package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.AnswerDto;
import com.cinema.domain.Criteria;
import com.cinema.domain.QuestionDto;
import com.cinema.mapper.CustomerManagerMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class CustomerManagerServiceImpl implements CustomerManagerService {

	private CustomerManagerMapper customerManagerMapper;

	@Override
	public List<QuestionDto> questionManagerList(Criteria cri){
		return customerManagerMapper.questionManagerList(cri);
	}
	@Override
	public List<AnswerDto> answerManagerList(Criteria cri){
		return customerManagerMapper.answerManagerList(cri);
	}
	@Override
	public int questionManagerGetTotalCount() {
		return customerManagerMapper.questionManagerGetTotalCount();
	}
	@Override
	public int answerManagerGetTotalCount() {
		return customerManagerMapper.answerManagerGetTotalCount();
	}
	@Override
	public List<QuestionDto> questionManagerGet(long questionNo){
		return customerManagerMapper.questionManagerGet(questionNo);
	}
	@Override
	public List<AnswerDto> answerManagerGet(long answerNo){
		return customerManagerMapper.answerManagerGet(answerNo);
	}
	@Override
	public boolean answerManagerRegister(AnswerDto answerDto) {
		return customerManagerMapper.answerManagerRegister(answerDto);
	}

}
