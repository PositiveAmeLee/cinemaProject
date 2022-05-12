package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieVO;

public interface MovieService {
	
//	01. 영화 목록
	public List<MovieVO> movieList();	
	
//	02. 영화 상세
	public MovieVO movieInfo(long movie_no);
	
	
//	03. 영화 정렬
	public List<MovieVO> sortStarRating();
	
	public List<MovieVO> sortResRating();
	
//	public List<MovieVO> sortReleasedate(date movie_release_date);
	
//	04. 영화 검색
	public List<MovieVO> movieSearch(Criteria cri);
	
	
	

}
