package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerResultMap;

public interface ReservationManagerService {

	public List<ReservationManagerResultMap> reservationManagerList(Criteria cri);

	public int reservationManagerGetTotalCount();

	public List<ReservationManagerResultMap> reservationManagerGet(long resNo);

	public boolean reservationManagerManagerModify(ReservationManagerResultMap reservationManagerResultMap);

	public boolean reservationManagerManagerDelete(long resNo);

}
