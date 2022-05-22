package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto;
import com.cinema.mapper.NoticeManagerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor//생성자 주입
public class NoticeManagerServiceImpl implements NoticeManagerService {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final NoticeManagerMapper noticeManagerMapper;
	
	@Override
	public boolean noticeManagerRegister(NoticeDto.NoticeCreateDto createDto) {
		return noticeManagerMapper.noticeManagerRegister(createDto);
	}

	@Override
	public List<NoticeDto.NoticeResultDto> noticeManagerList(Criteria cri) {
		return noticeManagerMapper.noticeManagerList(cri);
	}

	@Override
	public int noticeManagerGetTotalCount() {
		return noticeManagerMapper.noticeManagerGetTotalCount();
	}

	@Override
	public NoticeDto.NoticeResultDto noticeManagerGet(long noticeNo) {
		return noticeManagerMapper.noticeManagerGet(noticeNo);
	}

	@Override
	public boolean noticeManagerModify(NoticeDto.NoticeModifyDto modifyDto) {
		return noticeManagerMapper.noticeManagerModify(modifyDto);
	}

	@Override
	public boolean noticeManagerDelete(long noticeNo) {
		return noticeManagerMapper.noticeManagerDelete(noticeNo);
	}

}
