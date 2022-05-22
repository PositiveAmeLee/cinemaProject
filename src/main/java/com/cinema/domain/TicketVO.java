package com.cinema.domain;

import lombok.Data;

@Data
public class TicketVO {
	
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
}
