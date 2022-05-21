package com.cinema.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentManagerResultMap {

	private long memberNo;
	private long movieNo;
	private long commentNo;
	private String commentContents;
	private Date commentCreateTime;
	private Date commentUpdateTime;
	private long commentStarRating;
	private String movieTitle;
	private String memberId;
	private String memberName;
	private String memberNickname;
	
}
