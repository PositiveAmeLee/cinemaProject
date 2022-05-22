package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieDto;
import com.cinema.mapper.MovieManagerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor//생성자 주입
public class MovieManagerServiceImpl implements MovieManagerService {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final MovieManagerMapper movieManagerMapper;
	
	@Override
	public List<MovieDto.MovieResultDto> movieManagerList(Criteria cri) {
		return movieManagerMapper.movieManagerList(cri);
	}
	
	public int movieManagerGetTotalCount() {
		return movieManagerMapper.movieManagerGetTotalCount();
	}
	
	public boolean movieManagerRegister(MovieDto.MovieCreateDto createDto) {
		return movieManagerMapper.movieManagerRegister(createDto);
	}

	@Override
	public MovieDto.MovieResultDto movieManagerGet(long movieNo) {
		return movieManagerMapper.movieManagerGet(movieNo);
	}

	@Override
	public boolean movieManagerModify(MovieDto.MovieModifyDto modifyDto) {
		return movieManagerMapper.movieManagerModify(modifyDto);
	}

	@Override
	public boolean movieManagerDelete(long movieNo) {
		return movieManagerMapper.movieManagerDelete(movieNo);
	}

}
