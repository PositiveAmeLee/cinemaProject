package com.cinema.service;

import java.util.List;

import com.cinema.domain.MovieDto;

public interface MovieService {
	

	public List<MovieDto.MovieResultDto> movieList();	

	public MovieDto.MovieResultDto movieInfo(long movieNo);

	

}
