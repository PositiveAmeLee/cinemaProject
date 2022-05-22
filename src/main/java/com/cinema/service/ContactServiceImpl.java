package com.cinema.service;

import org.springframework.stereotype.Service;

import com.cinema.domain.QuestionDto;
import com.cinema.mapper.ContactMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor//생성자 주입
public class ContactServiceImpl implements ContactService {
	//@Autowired 생략 = 스프링 4.3 이후 지원하는 묵시적 자동 주입
	private final ContactMapper contactMapper;

	@Override
	public int create(QuestionDto.QuestionCreateDto createDto) {
		return contactMapper.create(createDto);
	}
	
	
}
