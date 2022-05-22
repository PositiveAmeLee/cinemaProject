package com.cinema.domain;

import lombok.Data;

@Data
public class ReservationDto {

	private Long memberNO;
	private Long ticketNO;
	private String id;
	private int reserveSequence;
	private String title;
	private String runningTime;
	private String movieDate;
	private String ticketNumber;
	private String selectedSeat;
	private String selectedTheater;
	private String movieAge;
	
	@Data
	public static class ReservationCreateDto{
		private String title;
		private String runningTime;
		private String movieDate;
		private String ticketNumber;
		private String selectedSeat;
		private String selectedTheater;
		private String movieAge;
	}
	
	@Data
	public static class ReservationResultDto{
		private Long ticketNO;
		private String id;
		private int reserveSequence;
		private String title;
		private String runningTime;
		private String movieDate;
		private String ticketNumber;
		private String selectedSeat;
		private String selectedTheater;
		private String movieAge;
	}
}
