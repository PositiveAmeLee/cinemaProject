package com.cinema.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class NoticeDto {
	
	@Data
	@NoArgsConstructor
	public static class NoticeCreateDto{
		
		private String noticeTitle;
		private String noticeContents;
		
		@Builder
		public NoticeCreateDto(String noticeTitle,String noticeContents) {
			this.noticeTitle=noticeTitle;
			this.noticeContents=noticeContents;
		}
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
	@NoArgsConstructor
	public static class NoticeModifyDto{
		
		private long noticeNo;
		private String noticeTitle;
		private String noticeContents;
		
		@Builder
		public NoticeModifyDto(long noticeNo,String noticeTitle,String noticeContents) {
			this.noticeNo=noticeNo;
			this.noticeTitle=noticeTitle;
			this.noticeContents=noticeContents;
		}
		
		
	}
}
