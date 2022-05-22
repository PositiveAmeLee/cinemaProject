package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.MovieDto;

public interface MovieMapper {

	public List<MovieDto.MovieResultDto> movieList();

	public MovieDto.MovieResultDto movieInfo(long movieNo);

}
