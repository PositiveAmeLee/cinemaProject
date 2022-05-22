package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.ReservationDto;
import com.cinema.domain.TicketVO;
import com.cinema.mapper.ReservationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor//생성자주입
public class ReservationServiceImpl implements ReservationService {
	//@Autowired 생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private ReservationMapper reservationMapper;
	
	@Override
	public TicketVO get(Long ticketNO) {
		return reservationMapper.get(ticketNO); 
	}

	@Override
	public List<ReservationDto.ReservationResultDto> getAll(Long memberNO) {
		return reservationMapper.getAll(memberNO);
	}

	@Override
	public int ticketing(ReservationDto.ReservationCreateDto createDto) {
		return reservationMapper.ticketing(createDto);
	}

	@Override
	public int cancel(Long ticketNO) {
		return reservationMapper.cancel(ticketNO);
	}
	
	

}
