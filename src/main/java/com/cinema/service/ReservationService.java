package com.cinema.service;

import java.util.List;

import com.cinema.domain.ReservationDto;

public interface ReservationService {

	public ReservationDto.ReservationResultDto get(Long ticketNO);
	
	public List<ReservationDto.ReservationResultDto> getAll(Long memberNO);
	
	public int ticketing(ReservationDto.ReservationCreateDto createDto);
	
	public int cancel(Long ticketNO);
}
