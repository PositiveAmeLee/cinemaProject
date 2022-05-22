package com.cinema.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MovieDto {

    
	@Data
	public static class MovieResultDto {
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
		private String movieStatus;
	}

	@Data
	public static class MovieCreateDto {
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
		private String movieStatus;
		private String movieImage;
		private String moviePlaytime;
	}

	@Data
	public static class MovieModifyDto {
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
		private String movieStatus; 
		private String movieImage;
		private String moviePlaytime;
	}
}
