package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberManagerDto;
import com.cinema.mapper.MemberManagerMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class MemberManagerServiceImpl implements MemberManagerService {

	@Autowired(required = false)
	MemberManagerMapper memberManagerMapper;
	
	@Autowired(required = false)
	MemberManagerDto memberManagerDto;

	@Override
	public List<MemberManagerDto> memberList(Criteria cri) {
		return memberManagerMapper.memberGetListWithPaging(cri);
	}

	@Override
	public int memberGetTotal() {
		return memberManagerMapper.memberGetTotalCount();
	}

	@Override
	public List<MemberManagerDto> memberGet(long memberNo) {
		return memberManagerMapper.memberGet(memberNo);
	}

	@Override
	public boolean memberModify(MemberManagerDto memberManagerDto) {
		return memberManagerMapper.memberModify(memberManagerDto);
	}

}
