package com.cinema.service;

import java.util.List;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeManagerDto;

public interface NoticeManagerService {
	
	public boolean noticeManagerRegister(NoticeManagerDto noticeManagerDto);

	public List<NoticeManagerDto> noticeManagerList(Criteria cri);
	
	public int noticeManagerGetTotalCount();
	
	public List<NoticeManagerDto> noticeManagerGet(long noticeNo);
	
	public boolean noticeManagerModify(NoticeManagerDto noticeManagerDto);
	
	public boolean noticeManagerDelete(long noticeNo);

}
