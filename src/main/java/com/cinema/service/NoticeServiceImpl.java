package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto.NoticeResultDto;
import com.cinema.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor//생성자 주입
public class NoticeServiceImpl implements NoticeService {
	//@Autowired 생략 = 스프링 4.3 이후 지원하는 묵시적 자동주입
	private final NoticeMapper noticeMapper;

	@Override
	public List<NoticeResultDto> getList(Criteria cri) {
		return noticeMapper.getList(cri);
	}

	@Override
	public NoticeResultDto get(long NoticeNo) {
		return noticeMapper.get(NoticeNo);
	}
}
