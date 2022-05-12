package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieVO;
import com.cinema.mapper.MovieMapper;


@Service
public class MovieServiempl implements MovieService {
	private MovieMapper movieMapper;

	@Override
	public List<MovieVO> movieList() {
		// TODO Auto-generated method stub
		return movieMapper.movieList();
	}

	@Override
	public MovieVO movieInfo(long movie_no) {
		// TODO Auto-generated method stub
		return movieMapper.movieInfo(movie_no);
	}

	@Override
	public List<MovieVO> sortStarRating() {
		// TODO Auto-generated method stub
		return movieMapper.sortByStar();
	}

	@Override
	public List<MovieVO> sortResRating() {
		// TODO Auto-generated method stub
		return movieMapper.sortByRes();
	}

	@Override
	public List<MovieVO> movieSearch(Criteria cri) {
		// TODO Auto-generated method stub
		return movieMapper.movieSearch(cri);
	}

//	@Override
//	public List<MovieVO> sortReleasedate(date movie_release_date) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
