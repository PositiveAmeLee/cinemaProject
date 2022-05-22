package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto;

public interface NoticeMapper {

	public List<NoticeDto.NoticeResultDto> getList(Criteria cri);
	
	public NoticeDto.NoticeResultDto get(long NoticeNo);
	
}
