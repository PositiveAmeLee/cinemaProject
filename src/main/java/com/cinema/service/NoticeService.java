package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto;

public interface NoticeService {

	public List<NoticeDto.NoticeResultDto> getList(Criteria cri);
	
	public NoticeDto.NoticeResultDto get(long NoticeNo);
}
