package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieManagerDto;

public interface MovieManagerMapper {
	
	public List<MovieManagerDto> movieManagerList(Criteria cri);
	
	public int movieManagerGetTotalCount();
	
	public boolean movieManagerRegister(MovieManagerDto movieManagerDto);

	public List<MovieManagerDto> movieManagerGet(long movieNo);
	
	public boolean movieManagerModify(MovieManagerDto movieManagerDto);
	
	public boolean movieManagerDelete(long movieNo);
	
}
