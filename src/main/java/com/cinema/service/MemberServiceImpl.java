package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.MemberDto;
import com.cinema.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //생성자 주입
public class MemberServiceImpl implements MemberService {
	// @Autowired 생략 = 스프링 4.3이후 지원하는 묵시적 자동 주입
	private final MemberMapper memberMapper;
	
	@Override
	public int memberJoin(MemberDto.MemberCreateDto createDto) {
		return memberMapper.memberJoin(createDto);
	}

	@Override
	public MemberDto.MemberLoginResponseDto login(MemberDto.MemberLoginRequestDto requestDto) {
		return memberMapper.login(requestDto);
	}

	@Override
	public int memberModify(MemberDto.MemberModifyDto modifyDto) {
		return memberMapper.memberModify(modifyDto);
	}
	
	@Override
	public String overlapped(String id) {
		return memberMapper.overlapped(id);
	}

	@Override
	public List<String> findId(MemberDto.MemberFindIdDto findIdDto) {
		return memberMapper.findId(findIdDto);
	}

	@Override
	public int delete(long memberno) {
		return memberMapper.delete(memberno);
	}
}
