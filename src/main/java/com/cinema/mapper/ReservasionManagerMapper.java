package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerDto;

public interface ReservasionManagerMapper {
	
	public List<ReservationManagerDto> reservationList();
	
	public int reservationGetTotalCount();
	
	public List<ReservationManagerDto> reservationDetail(long resNo);
	
	public boolean reservationDetailModify(ReservationManagerDto reservationManagerDto);
	
	public boolean reservationManagerDelete(long resNo);
	
	public List<ReservationManagerDto> reservationManagerSearch(Criteria cri);

}
