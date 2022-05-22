package com.cinema.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MovieMapperTests {

	@Autowired
	private MovieMapper movieMapper;
	
	@Test
	public void testMapper() {
		log.info(movieMapper);
	}
	
	@Test
	public void testMovieList() {
		List<MovieDto.MovieResultDto> list = movieMapper.movieList();
		log.info(list);
	}
	
	@Test
	public void testMovieGet() {
		long movieNo =21L;
		MovieDto.MovieResultDto resultDto = movieMapper.movieInfo(movieNo);
		log.info(resultDto);
	}
}
