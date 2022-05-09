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
public class ReservationManagerDto {

	private long resNo;
	private long memberNo;
	private long movieNo;
	private String movieTitle;
	private String movieEtitle;
	private String movieType;
	private String movieGrade;
	private String resCinema;
	private Date resDate;
	private String resTheater;
	private String resPerson;
	private int resTotal;
	private String resSeatNo;
	
}
