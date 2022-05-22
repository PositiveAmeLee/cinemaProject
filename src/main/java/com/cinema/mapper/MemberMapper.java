package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.MemberDto;

public interface MemberMapper {
	
	public int memberJoin(MemberDto.MemberCreateDto createDto);

	public MemberDto.MemberLoginResponseDto login(MemberDto.MemberLoginRequestDto requestDto);
	
	public int memberModify(MemberDto.MemberModifyDto modifyDTo);

	public String overlapped(String id);

	public List<String> findId(MemberDto.MemberFindIdDto findIdDto);

	public int delete(long memberno);
	
	
	
}
