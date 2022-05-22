package com.cinema.domain;

import java.util.Date;

import lombok.Data;


public class NoticeDto {
	
	@Data
	public static class NoticeCreateDto{
		
		private String noticeTitle;
		private String noticeContents;
		
	}
	
	@Data
	public static class NoticeResultDto{
		
		private long noticeNo;
		private String noticeTitle;
		private String noticeContents;
		private Date noticeCreateTime;
		private Date noticeUpdateTime;
		
	}
	
	@Data
	public static class NoticeModifyDto{
		
		private long noticeNo;
		private String noticeTitle;
		private String noticeContents;
		
	}
}
