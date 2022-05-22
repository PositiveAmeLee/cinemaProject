package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieDto;

public interface MovieManagerService {

	public List<MovieDto.MovieResultDto> movieManagerList(Criteria cri);

	public int movieManagerGetTotalCount();

	public boolean movieManagerRegister(MovieDto.MovieCreateDto createDto);

	public MovieDto.MovieResultDto movieManagerGet(long movieNo);

	public boolean movieManagerModify(MovieDto.MovieModifyDto modifyDto);

	public boolean movieManagerDelete(long movieNo);

}
