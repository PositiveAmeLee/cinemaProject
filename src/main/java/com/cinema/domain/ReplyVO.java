package com.cinema.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class ReplyVO extends BaseVO{
	
	private Long replyNO;
	
	private Long movieNO;

	private Long memberNO;
	
	private String title;
	
	private String content;
	
	private int stars;
	
}
