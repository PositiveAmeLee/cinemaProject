package com.cinema.domain;

import lombok.Data;


public class MemberDto {

	@Data
	public static class MemberCreateDto{
		private String memberId;
		private String memberPw;
		private String memberName;
		private String memberGender;
		private String memberBirth_y;
		private String memberBirth_m;
		private String memberBirth_d;
		private String memberBirth_gn;
		private String tel1;
		private String tel2;
		private String tel3;
		private String hp1;
		private String hp2;
		private String hp3;
		private String smssts_yn;
		private String email1;
		private String email2;
		private String emailsts_yn;
		private String zipcode;
		private String roadAddress;
		private String jibunAddress;
		private String namujiAddress;
	}
	
	@Data
	public static class MemberLoginRequestDto{
		private String memberId;
		private String memberPw;
	}
	
	@Data
	public static class MemberLoginResponseDto{
		private long memberNo;
		private String memberId;
		private String memberPw;
		private String memberName;
		private String memberGender;
		private String memberBirth_y;
		private String memberBirth_m;
		private String memberBirth_d;
		private String memberBirth_gn;
		private String tel1;
		private String tel2;
		private String tel3;
		private String hp1;
		private String hp2;
		private String hp3;
		private String smssts_yn;
		private String email1;
		private String email2;
		private String emailsts_yn;
		private String zipcode;
		private String roadAddress;
		private String jibunAddress;
		private String namujiAddress;
		private String del_yn;
	}
	
	@Data
	public static class MemberModifyDto{
		private long memberNo;
		private String memberPw;
		private String tel1;
		private String tel2;
		private String tel3;
		private String hp1;
		private String hp2;
		private String hp3;
		private String smssts_yn;
		private String email1;
		private String email2;
		private String emailsts_yn;
		private String zipcode;
		private String roadAddress;
		private String jibunAddress;
		private String namujiAddress;
	}
	
	@Data
	public static class MemberFindIdDto{
		private String email1;
		private String email2;
	}
}
