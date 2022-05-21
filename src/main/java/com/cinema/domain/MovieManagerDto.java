package com.cinema.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieManagerDto {

	private long movieNo;
	private String movieTitle;
	private String movieEtitle;
	private String movieDirector;
	private String movieActor;
	private String movieType;
	private String movieGenre;
	private String movieGrade;
	private String movieContents;
	private String movieImage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date movieOpendate;
	private String moviePlaytime;
	private int movieResRating;
	private int commentStarRating;
	private String movieStatus;
	
}
