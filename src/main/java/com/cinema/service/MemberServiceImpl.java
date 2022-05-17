package com.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.MemberVO;
import com.cinema.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public int memberJoin(MemberVO memberVO) {
		return memberMapper.memberJoin(memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		return memberMapper.login(memberVO);
	}

	@Override
	public String overlapped(String id) {
		return memberMapper.overlapped(id);
	}

	@Override
	public int memberModify(MemberVO memberVO) {
		return memberMapper.memberModify(memberVO);
	}
}
