package com.cinema.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MovieVO {
	private long movie_no;
	private String movie_title;
	private String movie_genre;
	private String movie_director;
	private String movie_cast;
	private String movie_synopsis;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date movie_release_date;
	private double movie_res_rating;
	private double movie_star_rating;
	private boolean movie_state;
	private String movie_trailer;
	private String movie_image_file_name;
}
