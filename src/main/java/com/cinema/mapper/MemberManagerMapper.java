package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;

public interface MemberManagerMapper {
	
	public List<MemberManagerDto> memberGetListWithPaging(Criteria cri);
	
	public int memberGetTotalCount();
	
	public List<MemberManagerDto> memberGet(long memberNo);
	
	public boolean memberModify(MemberManagerDto memberManagerDto);
	
}
