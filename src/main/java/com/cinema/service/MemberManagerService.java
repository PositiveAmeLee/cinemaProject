package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;

public interface MemberManagerService {
	
	public List<MemberManagerDto> memberList(Criteria cri);
	
	public int memberGetTotal();
	
	public List<MemberManagerDto> memberGet(long memberNo);
	
	public boolean memberModify(MemberManagerDto memberManagerDto);
	
}
