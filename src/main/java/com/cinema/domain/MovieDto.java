package com.cinema.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
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
		private String movieTrailer;
	}

	@Data
	@NoArgsConstructor
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
		
		@Builder
		public MovieCreateDto(String movieTitle,String movieEtitle,String movieDirector,String movieActor,String movieType,
				String movieGenre,String movieGrade,String movieContents,Date movieOpenDate,String movieStatus,
				String movieImage,String moviePlayTime) {
			this.movieTitle=movieTitle;
			this.movieEtitle=movieEtitle;
			this.movieDirector=movieDirector;
			this.movieActor=movieActor;
			this.movieType=movieType;
			this.movieGenre=movieGenre;
			this.movieGrade=movieGrade;
			this.movieContents=movieContents;
			this.movieOpendate=movieOpenDate;
			this.movieStatus=movieStatus;
			this.movieImage=movieImage;
			this.moviePlaytime=moviePlayTime;
		}
	}

	@Data
	@NoArgsConstructor
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
		
		@Builder
		public MovieModifyDto(long movieNo,String movieTitle,String movieEtitle,String movieDirector,String movieActor,String movieType,
				String movieGenre,String movieGrade,String movieContents,Date movieOpenDate,String movieStatus,
				String movieImage,String moviePlayTime) {
			this.movieNo=movieNo;
			this.movieTitle=movieTitle;
			this.movieEtitle=movieEtitle;
			this.movieDirector=movieDirector;
			this.movieActor=movieActor;
			this.movieType=movieType;
			this.movieGenre=movieGenre;
			this.movieGrade=movieGrade;
			this.movieContents=movieContents;
			this.movieOpendate=movieOpenDate;
			this.movieStatus=movieStatus;
			this.movieImage=movieImage;
			this.moviePlaytime=moviePlayTime;
		}
	}
}
