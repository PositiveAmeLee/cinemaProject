package com.cinema.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CommentDto {

	@Data
	public static class CommnetManagerDto {

		private long memberNo;
		private long movieNo;
		private long commentNo;
		private String commentContents;
		private Date commentCreateTime;
		private Date commentUpdateTime;
		private long commentStarRating;

	}

	@Data
	public static class CommentResultDto {

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
		private String del_yn;

	}

	@Data
	@NoArgsConstructor // 빌더패턴을 위한 기본생성자
	public static class CommentCreateDto {

		private long memberNO;
		private long movieNo;
		private String commentContents;
		private long commentStarRating;
		private String movieTitle;
		private String memberId;
		private String memberName;
		private String memberNickname;
		
		@Builder //단위테스트를 위해 빌더패턴을 사용
		public CommentCreateDto(long memberNo, long movieNO, String commentContents, long commentStarRating,
				String movieTitle, String memberId, String memberName, String memberNickName) {
			this.memberNO=memberNo;
			this.movieNo=movieNO;
			this.commentContents=commentContents;
			this.commentStarRating=commentStarRating;
			this.movieTitle=movieTitle;
			this.memberId=memberId;
			this.memberName=memberName;
			this.memberNickname=memberNickName;
		}
	}
	
	@Data
	@NoArgsConstructor //빌더패턴을 위한 기본생성자
	public static class CommentUpdateDto{
		
		private long commentNo;
		private String commentContents;
		private long commentStarRating;
		
		@Builder //단위테스트를 위해 빌더패턴을 사용
		public CommentUpdateDto(long commentNo,String commentContents,long commentStarRating) {
			this.commentNo=commentNo;
			this.commentContents=commentContents;
			this.commentStarRating=commentStarRating;
		}
	}

}
