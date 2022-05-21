package com.cinema.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeManagerDto {
	
	private long noticeNo;
	private String noticeTitle;
	private String noticeContents;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date noticeCreateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date noticeUpdateTime;
	
}
