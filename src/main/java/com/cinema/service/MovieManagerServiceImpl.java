package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieManagerDto;
import com.cinema.mapper.MovieManagerMapper;

@Service
public class MovieManagerServiceImpl implements MovieManagerService {

	MovieManagerDto movieManagerDto;
	
	@Autowired
	MovieManagerMapper movieManagerMapper;
	
	@Override
	public List<MovieManagerDto> loadMovieList() {
		return movieManagerMapper.movieList();
	}
	
	public int movieGetTotalCount() {
		return movieManagerMapper.movieGetTotalCount();
	}
	
	public boolean movieRegister(MovieManagerDto movieManagerDto) {
		return movieManagerMapper.movieRegister(movieManagerDto);
	}

	@Override
	public List<MovieManagerDto> loadMovieDetail(long movieNo) {
		return movieManagerMapper.movieDetail(movieNo);
	}

	@Override
	public boolean modifyMovieDetail(MovieManagerDto movieManagerDto) {
		return movieManagerMapper.movieDetailModify(movieManagerDto);
	}

	@Override
	public boolean deleteMovie(long movieNo) {
		return movieManagerMapper.movieDelete(movieNo);
	}

	@Override
	public List<MovieManagerDto> searchMovie(Criteria cri) {
		return movieManagerMapper.movieSearch(cri);
	}

}
