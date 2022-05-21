package com.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
	
	private long questionNo;
	private long memberNo;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String questionTitle;
	private String questionContents;
	
}
