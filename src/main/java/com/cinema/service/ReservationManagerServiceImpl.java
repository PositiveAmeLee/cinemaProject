package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerDto;
import com.cinema.mapper.ReservasionManagerMapper;

@Service
public class ReservationManagerServiceImpl implements ReservationManagerService {

	ReservationManagerDto reservationManagerDto;
	
	@Autowired
	ReservasionManagerMapper reservationManagerMapper;
	
	@Override
	public List<ReservationManagerDto> reservationList() {
		return reservationManagerMapper.reservationList();
	}

	@Override
	public int reservationGetTotalCount() {
		return reservationManagerMapper.reservationGetTotalCount();
	}

	@Override
	public List<ReservationManagerDto> reservationDetail(long resNo) {
		return reservationManagerMapper.reservationDetail(resNo);
	}

	@Override
	public boolean reservationDetailModify(ReservationManagerDto reservationManagerDto) {
		return reservationManagerMapper.reservationDetailModify(reservationManagerDto);
	}

	@Override
	public boolean reservationManagerDelete(long resNo) {
		return reservationManagerMapper.reservationManagerDelete(resNo);
	}

	@Override
	public List<ReservationManagerDto> reservationManagerSearch(Criteria cri) {
		return reservationManagerMapper.reservationManagerSearch(cri);
	}

}
