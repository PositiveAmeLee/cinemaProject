package com.cinema.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentManagerDto {

	private long memberNo;
	private long movieNo;
	private long commentNo;
	private String commentContents;
	private Date commentCreateTime;
	private Date commentUpdateTime;
	private long commentStarRating;
	
}
