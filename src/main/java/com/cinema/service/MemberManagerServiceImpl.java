package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;
import com.cinema.mapper.MemberManagerMapper;

@Service
public class MemberManagerServiceImpl implements MemberManagerService {
	
	@Autowired
	MemberManagerMapper memberManagerMapper;

	@Override
	public List<MemberManagerDto> loadMemberList(Criteria cri) {
		return memberManagerMapper.memberGetListWithPaging(cri);
	}

	@Override
	public int memberGetTotal() {
		return memberManagerMapper.memberGetTotalCount();
	}

	@Override
	public List<MemberManagerDto> loadMemberDetail(long memberNo) {
		return memberManagerMapper.memberDetail(memberNo);
	}

	@Override
	public boolean modifyMemberDetail(MemberManagerDto memberManagerDto) {
		return memberManagerMapper.memberDetailModify(memberManagerDto);
	}

	@Override
	public List<MemberManagerDto> searchMember(Criteria cri) {
		return memberManagerMapper.memberSearch(cri);
	}

}
