package com.cinema.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationManagerResultMap {

	private long resNo;
	private long memberNo;
	private long movieNo;
	private String memberId;
	private String memberName;
	private String memberNickname;
	private String movieTitle;
	private String movieEtitle;
	private String movieType;
	private String movieGrade;
	private String resCinema;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date resDate;
	private String resTheater;
	private String resPerson;
	private int resTotal;
	private String resSeatNo;
	
}
