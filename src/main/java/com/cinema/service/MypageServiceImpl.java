package com.cinema.service;

import org.springframework.stereotype.Service;

import com.cinema.domain.ContactVO;
import com.cinema.mapper.MypageMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MypageServiceImpl implements MypageService {

	private MypageMapper mypageMapper;

	@Override
	public int create(ContactVO contactVO) {
		return mypageMapper.create(contactVO);
	}
	
	
}
