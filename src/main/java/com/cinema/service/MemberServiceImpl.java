package com.cinema.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<MemberVO> findId(Map<String,String> emailMap) {
		return memberMapper.findId(emailMap);
	}

	@Override
	public int delete(int member_no) {
		return memberMapper.delete(member_no);
	}
}
