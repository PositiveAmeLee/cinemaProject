package com.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

	private long answerNo;
	private long questionNo;
	private long memberNo;
	private String answerTitle;
	private String answerContents;
	private String questionTitle;
	private String questionContents;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
}
