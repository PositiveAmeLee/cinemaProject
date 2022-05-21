package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.ReservationManagerResultMap;
import com.cinema.mapper.ReservationManagerMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationManagerServiceImpl implements ReservationManagerService {

	@Autowired(required = false)
	ReservationManagerResultMap reservationManagerResultMap;

	@Autowired
	ReservationManagerMapper reservationManagerMapper;

	@Override
	public List<ReservationManagerResultMap> reservationManagerList(Criteria cri) {
		return reservationManagerMapper.reservationManagerList(cri);
	}

	@Override
	public int reservationManagerGetTotalCount() {
		return reservationManagerMapper.reservationManagerGetTotalCount();
	}

	@Override
	public List<ReservationManagerResultMap> reservationManagerGet(long resNo) {
		return reservationManagerMapper.reservationManagerGet(resNo);
	}

	@Override
	public boolean reservationManagerManagerModify(ReservationManagerResultMap reservationManagerResultMap) {
		return reservationManagerMapper.reservationManagerModify(reservationManagerResultMap);
	}

	@Override
	public boolean reservationManagerManagerDelete(long resNo) {
		return reservationManagerMapper.reservationManagerDelete(resNo);
	}

}
