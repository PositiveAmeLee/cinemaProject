package com.cinema.mapper;

import com.cinema.domain.MemberVO;

public interface MemberMapper {
	
	// 회원가입
	public int memberJoin(MemberVO memberVO);

	// 로그인
	public MemberVO login(MemberVO memberVO);
	
	//회원정보수정
	public int memberModify(MemberVO memberVO);

	//아이디중복확인
	public String overlapped(String id);
	
	//회원탈퇴
	
	
}
