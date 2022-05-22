package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;

public interface MemberManagerService {
	
	public List<MemberDto.MemberResultDto> memberList(Criteria cri);
	
	public int memberGetTotal();
	
	public MemberDto.MemberResultDto memberGet(long memberNo);
	
	public boolean memberModify(MemberDto.MemberModifyDto modifyDto);
	
}
