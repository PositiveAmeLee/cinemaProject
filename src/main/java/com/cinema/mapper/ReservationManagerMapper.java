package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerResultMap;

public interface ReservationManagerMapper {
	
	public List<ReservationManagerResultMap> reservationManagerList(Criteria cri);
	
	public int reservationManagerGetTotalCount();
	
	public List<ReservationManagerResultMap> reservationManagerGet(long resNo);
	
	public boolean reservationManagerModify(ReservationManagerResultMap reservationManagerResultMap);
	
	public boolean reservationManagerDelete(long resNo);
	
}
