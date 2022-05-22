package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieDto;
import com.cinema.mapper.MovieMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor//생성자 주입
public class MovieServiempl implements MovieService {
	//@Autowired 생략 = 스프링 4.3 이후 지원하는 묵시적 자동 주입
	private final MovieMapper movieMapper;

	@Override
	public List<MovieDto.MovieResultDto> movieList() {
		return movieMapper.movieList();
	}

	@Override
	public MovieDto.MovieResultDto movieInfo(long movieNo) {
		return movieMapper.movieInfo(movieNo);
	}


}
