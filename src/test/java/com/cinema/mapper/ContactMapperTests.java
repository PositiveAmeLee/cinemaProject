package com.cinema.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.QuestionDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ContactMapperTests {

	@Autowired
	private ContactMapper contactMapper;
	
	@Test
	public void testMapper() {
		log.info(contactMapper);
	}
	
	@Test
	public void testCreate() {
		QuestionDto.QuestionCreateDto createDto = new QuestionDto.QuestionCreateDto().builder()
				.memberName("testName")
				.memberPhone("010-1111-1111")
				.memberEmail("testEmail@test.com")
				.memberNo(1L)
				.questionContents("testContents")
				.build();
		int result = contactMapper.create(createDto);
		log.info(result);
	}
}
