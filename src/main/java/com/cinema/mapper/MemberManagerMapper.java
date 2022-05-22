package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;

public interface MemberManagerMapper {
	
	public List<MemberDto.MemberResultDto> memberGetListWithPaging(Criteria cri);
	
	public int memberGetTotalCount();
	
	public MemberDto.MemberResultDto memberGet(long memberNo);
	
	public boolean memberModify(MemberDto.MemberModifyDto modifyDto);
	
}
