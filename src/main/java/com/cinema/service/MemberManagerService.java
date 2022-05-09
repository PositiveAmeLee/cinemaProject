package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;

public interface MemberManagerService {
	
	

	public List<MemberManagerDto> loadMemberList(Criteria cri);
	
	public int memberGetTotal();
	
	public List<MemberManagerDto> loadMemberDetail(long memberNo);
	
	public boolean modifyMemberDetail(MemberManagerDto memberManagerDto);
	
	public List<MemberManagerDto> searchMember(Criteria cri);
	
}
