package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MovieVO;

public interface MovieMapper {

	public List<MovieVO> movieList();

	public MovieVO movieInfo(long movie_no);

//	@Select("Select * from movie order by movie_star_rating")
	public List<MovieVO> sortByStar();

//	@Select("Select * from movie order by movie_res_rating")
	public List<MovieVO> sortByRes();

//	@Select("Select * from movie order by movie_release_date")
//	public List<MovieVO> sortReleaseDate(date movie_release_date);

//	@Select(select * from movie where movie_title like concat('%', #{search}, '%') order by num desc")
	public List<MovieVO> movieSearch(Criteria cri);

}
