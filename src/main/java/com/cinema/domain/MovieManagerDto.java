package com.cinema.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
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
	private Date movieOpendate;
	private int movieResRating;
	private int commentStarRating;
}
