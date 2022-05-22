package com.cinema.service;

import java.util.List;

import com.cinema.domain.ReservationDto;
import com.cinema.domain.TicketVO;

public interface ReservationService {

	public TicketVO get(Long ticketNO);
	
	public List<ReservationDto.ReservationResultDto> getAll(Long memberNO);
	
	public int ticketing(ReservationDto.ReservationCreateDto createDto);
	
	public int cancel(Long ticketNO);
}
