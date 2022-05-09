package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieManagerDto;

public interface MovieManagerMapper {
	
	public List<MovieManagerDto> movieList();
	
	public int movieGetTotalCount();
	
	public boolean movieRegister(MovieManagerDto movieManagerDto);

	public List<MovieManagerDto> movieDetail(long movieNo);
	
	public boolean movieDetailModify(MovieManagerDto movieManagerDto);
	
	public boolean movieDelete(long movieNo);
	
	public List<MovieManagerDto> movieSearch(Criteria cri);
}
