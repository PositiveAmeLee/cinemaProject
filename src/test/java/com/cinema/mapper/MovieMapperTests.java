package com.cinema.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MovieMapperTests {

	@Setter(onMethod_=@Autowired)
	private MovieMapper movieMapper;
	
	@Test
	public void MapperTests() {
		log.info(movieMapper);
	}
}
