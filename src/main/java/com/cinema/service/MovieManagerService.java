package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieManagerDto;

public interface MovieManagerService {

	public List<MovieManagerDto> loadMovieList();
	
	public int movieGetTotalCount();

	public boolean movieRegister(MovieManagerDto movieManagerDto);
	
	public List<MovieManagerDto> loadMovieDetail(long movieNo);
	
	public boolean modifyMovieDetail(MovieManagerDto movieManagerDto);
	
	public boolean deleteMovie(long movieNo);
	
	public List<MovieManagerDto> searchMovie(Criteria cri);

}
