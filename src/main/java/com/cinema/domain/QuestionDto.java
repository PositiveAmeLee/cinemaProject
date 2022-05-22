package com.cinema.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class QuestionDto {
	
	@Data
	@NoArgsConstructor //테스트 빌드패턴을 위한 기본생성자
	public static class QuestionCreateDto{
		private String memberName;
		private String memberPhone;
		private String memberEmail;
		private String questionContents;
		private long memberNo;
		
		@Builder
		public QuestionCreateDto(String memberName,String memberPhone,String memberEmail,String questionContents,long memberNo) {
			this.memberName=memberName;
			this.memberPhone=memberPhone;
			this.memberEmail=memberEmail;
			this.questionContents=questionContents;
			this.memberNo=memberNo;
		}
	}
	
	@Data
	public static class QuestionResultDto{
		private long questionNo;
		private long memberNo;
		private String memberName;
		private String memberPhone;
		private String memberEmail;
		private String questionContents;
	}
}
