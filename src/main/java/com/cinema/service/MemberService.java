package com.cinema.service;

import com.cinema.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public int memberJoin(MemberVO memberVO);
	
	//로그인
	public MemberVO login(MemberVO memberVO);

	//중복확인
	public String overlapped(String id);

	//회원정보수정
	public int memberModify(MemberVO memberVO);
	
}