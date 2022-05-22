package com.cinema.mapper;

import java.util.Date;
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
public class MovieManagerMapperTests {

	@Autowired
	private MovieManagerMapper movieManagerMapper;
	
	@Test
	public void testMapper() {
		log.info(movieManagerMapper);
	}
	
	@Test
	public void testMovieManagerList() {
		List<MovieDto.MovieResultDto> list = movieManagerMapper.movieManagerList(new Criteria());
		log.info(list);
	}
	
	@Test
	public void testMovieManagerGetTotalCount() {
		int result = movieManagerMapper.movieManagerGetTotalCount();
		log.info(result);
	}
	
	@Test
	public void testMovieManagerRegister() {
		MovieDto.MovieCreateDto createDto = MovieDto.MovieCreateDto.builder()
				.movieTitle("닥터 스트레인지: 대혼돈의 멀티버스")
				.movieEtitle("Doctor Strange in the Multiverse of Madness")
				.movieDirector("샘 레이미")
				.movieActor("베네딕트 컴버배치,엘리자베스 올슨")
				.movieType("2D")
				.movieGenre("액션,판타지,모험")
				.movieGrade("12세 관람가")
				.movieContents("지금껏 본 적 없는 마블의 극한 상상력!"
						+ "광기의 멀티버스가 깨어난다."
						+ "끝없이 균열되는 차원과 뒤엉킨 시공간의 멀티버스가 열리며"
						+ " 오랜 동료들, 그리고 차원을 넘어 들어온 새로운 존재들을 맞닥뜨리게 된 ‘닥터 스트레인지’."
						+ " 대혼돈 속, 그는 예상치 못한 극한의 적과 맞서 싸워야만 하는데….")
				.movieOpenDate(new Date())
				.movieStatus("상영중")
				.movieImage("https://movie-phinf.pstatic.net/20220504_33/165164173504831gKe_JPEG/movie_image.jpg")
				.moviePlayTime("126분")
				.build();
		boolean result = movieManagerMapper.movieManagerRegister(createDto);
		log.info(result);
	}
	
	@Test
	public void testMovieManagerGet() {
		long movieNo=21L;
		MovieDto.MovieResultDto reultDto = movieManagerMapper.movieManagerGet(movieNo);
		log.info(reultDto);
	}
	
	@Test
	public void testMovieManagerModify() {
		MovieDto.MovieModifyDto modifyDto = MovieDto.MovieModifyDto.builder()
				.movieNo(21L)
				.movieTitle("닥터 스트레인지: 대혼돈의 멀티버스")
				.movieEtitle("Doctor Strange in the Multiverse of Madness")
				.movieDirector("샘 레이미")
				.movieActor("베네딕트 컴버배치,엘리자베스 올슨")
				.movieType("2D")
				.movieGenre("액션,판타지,모험")
				.movieGrade("12세 관람가")
				.movieContents("지금껏 본 적 없는 마블의 극한 상상력!"
						+ "광기의 멀티버스가 깨어난다."
						+ "끝없이 균열되는 차원과 뒤엉킨 시공간의 멀티버스가 열리며"
						+ " 오랜 동료들, 그리고 차원을 넘어 들어온 새로운 존재들을 맞닥뜨리게 된 ‘닥터 스트레인지’."
						+ " 대혼돈 속, 그는 예상치 못한 극한의 적과 맞서 싸워야만 하는데….")
				.movieOpenDate(new Date())
				.movieStatus("상영중")
				.movieImage("https://movie-phinf.pstatic.net/20220504_33/165164173504831gKe_JPEG/movie_image.jpg")
				.moviePlayTime("126분")
				.build();
		boolean result = movieManagerMapper.movieManagerModify(modifyDto);
		log.info(result);
	}
	
	@Test
	public void testMovieManagerDelete() {
		long movieNo=21L;
		boolean result = movieManagerMapper.movieManagerDelete(movieNo);
		log.info(result);
	}
}

