package com.cinema.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CommentManagerDto {

	private long memberNo;
	private long movieNo;
	private long commentNo;
	private String commentTitle;
	private String commentContents;
	private Date commentCreateTime;
	private Date commentUpdateTime;
	private long commentStarRating;
	
}
