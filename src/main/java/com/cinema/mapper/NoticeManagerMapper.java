package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto;

public interface NoticeManagerMapper {
	
	public boolean noticeManagerRegister(NoticeDto.NoticeCreateDto createDto);

	public List<NoticeDto.NoticeResultDto> noticeManagerList(Criteria cri);
	
	public int noticeManagerGetTotalCount();
	
	public NoticeDto.NoticeResultDto noticeManagerGet(long noticeNo);
	
	public boolean noticeManagerModify(NoticeDto.NoticeModifyDto modifyDto);
	
	public boolean noticeManagerDelete(long noticeNo);
	
}
