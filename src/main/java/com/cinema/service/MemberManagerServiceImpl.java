package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;
import com.cinema.mapper.MemberManagerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class MemberManagerServiceImpl implements MemberManagerService {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final MemberManagerMapper memberManagerMapper;
	
	@Override
	public List<MemberDto.MemberResultDto> memberList(Criteria cri) {
		return memberManagerMapper.memberGetListWithPaging(cri);
	}

	@Override
	public int memberGetTotal() {
		return memberManagerMapper.memberGetTotalCount();
	}

	@Override
	public MemberDto.MemberResultDto memberGet(long memberNo) {
		return memberManagerMapper.memberGet(memberNo);
	}

	@Override
	public boolean memberModify(MemberDto.MemberModifyDto modifyDto) {
		return memberManagerMapper.memberModify(modifyDto);
	}

}
