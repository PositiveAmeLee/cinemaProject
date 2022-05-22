package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;

public interface MemberManagerMapper {
	
	public List<MemberDto> memberGetListWithPaging(Criteria cri);
	
	public int memberGetTotalCount();
	
	public List<MemberDto> memberGet(long memberNo);
	
	public boolean memberModify(MemberDto.MemberModifyDto modifyDto);
	
}
