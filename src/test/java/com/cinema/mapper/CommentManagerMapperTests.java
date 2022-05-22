package com.cinema.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentManagerMapperTests {

	@Autowired
	private CommentManagerMapper commentManagerMapper;
	
	@Test
	public void testMapper() {
		log.info(commentManagerMapper);
	}
	
	@Test
	public void testTotalGetCount() {
		int result = commentManagerMapper.commentManagerGetTotalCount();
		log.info("comment get total count: "+result);
	}

	@Test
	public void testDelete() {
		long CommentNO = 1L;
		boolean result = commentManagerMapper.commentManagerDelete(CommentNO);
		log.info("comment delete test: "+result);
	}
	
}
