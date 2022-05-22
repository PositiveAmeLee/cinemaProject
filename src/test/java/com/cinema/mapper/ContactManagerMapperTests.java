package com.cinema.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.Criteria;
import com.cinema.domain.QuestionDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ContactManagerMapperTests {
	
	@Autowired
	private ContactManagerMapper contactManagerMapper;
	
	@Test
	public void testMapper() {
		log.info(contactManagerMapper);
	}

	@Test
	public void testTotalGetCount() {
		int result = contactManagerMapper.questionManagerGetTotalCount();
		log.info(result);
	}
	
	@Test
	public void testQuestionManagerGet() {
		QuestionDto.QuestionResultDto resultDto = contactManagerMapper.questionManagerGet(1L);
		log.info(resultDto);
	}
	
	@Test
	public void testQuestionManagerList() {
		List<QuestionDto.QuestionResultDto> list = contactManagerMapper.questionManagerList(new Criteria());
		log.info(list);
	}
}
