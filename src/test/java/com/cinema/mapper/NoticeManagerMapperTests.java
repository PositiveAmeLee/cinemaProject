package com.cinema.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.Criteria;
import com.cinema.domain.NoticeDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeManagerMapperTests {

	@Autowired
	private NoticeManagerMapper noticeManagerMapper;
	
	@Test
	public void testMapper() {
		log.info(noticeManagerMapper);
	}
	
	@Test
	public void TestnoticeManagerRegister() {
		NoticeDto.NoticeCreateDto createDto = NoticeDto.NoticeCreateDto.builder()
				.noticeTitle("testNoticeTitle")
				.noticeContents("testNoticeContents")
				.build();
		boolean result = noticeManagerMapper.noticeManagerRegister(createDto);
		log.info(result);
	}
	
	@Test
	public void testNoticeManagerList() {
		Criteria cri = new Criteria();
		List<NoticeDto.NoticeResultDto> list = noticeManagerMapper.noticeManagerList(cri);
		log.info(list);
	}
	
	@Test
	public void testNoticeManagerGetTotalCount() {
		int result = noticeManagerMapper.noticeManagerGetTotalCount();
		log.info(result);
	}
	
	@Test
	public void testnoticeManagerGet() {
		long noticeNo=1L;
		NoticeDto.NoticeResultDto resultDto = noticeManagerMapper.noticeManagerGet(noticeNo);
		log.info(resultDto);
	}
	
	@Test
	public void testNoticeManagerModify() {
		NoticeDto.NoticeModifyDto modifyDto = NoticeDto.NoticeModifyDto.builder()
				.noticeNo(1L)
				.noticeTitle("updated title")
				.noticeContents("updated contents")
				.build();
		boolean result = noticeManagerMapper.noticeManagerModify(modifyDto);
		log.info(result);
	}
	
	@Test
	public void testNoticeManagerDelete() {
		long noticeNo = 1L;
		boolean result = noticeManagerMapper.noticeManagerDelete(noticeNo);
		log.info(result);
	}
}
