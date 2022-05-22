package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;

public interface MemberManagerService {
	
	public List<MemberDto> memberList(Criteria cri);
	
	public int memberGetTotal();
	
	public List<MemberDto> memberGet(long memberNo);
	
	public boolean memberModify(MemberDto.MemberModifyDto modifyDto);
	
}
