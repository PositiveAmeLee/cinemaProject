package com.cinema.mapper;

import java.util.List;
import java.util.Map;

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

	//아이디 찾기
	public List<MemberVO> findId(Map<String, String> emailMap);

	//회원탈퇴
	public int delete(int member_no);
	
	
	
}
