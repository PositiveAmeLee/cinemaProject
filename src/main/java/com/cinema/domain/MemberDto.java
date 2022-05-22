package com.cinema.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MemberDto {

	@Data
	@NoArgsConstructor
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
		
		@Builder
		public MemberCreateDto(String memberId,String memberPw,String memberName,String memberGender,String memberBirth_y,
				String memberBirth_m,String memberBirth_d,String memberBirth_gn,String tel1,String tel2,String tel3,
				String hp1,String hp2,String hp3,String smssts_yn,String email1,String email2,String emailsts_yn,String zipcode,
				String roadAddress,String jibunAddress,String namujiAddress) {
			this.memberId=memberId;
			this.memberPw=memberPw;
			this.memberName=memberName;
			this.memberGender=memberGender;
			this.memberBirth_y=memberBirth_y;
			this.memberBirth_m=memberBirth_m;
			this.memberBirth_d=memberBirth_d;
			this.memberBirth_gn=memberBirth_gn;
			this.tel1=tel1;
			this.tel2=tel2;
			this.tel3=tel3;
			this.hp1=hp1;
			this.hp2=hp2;
			this.hp3=hp3;
			this.smssts_yn=smssts_yn;
			this.email1=email1;
			this.email2=email2;
			this.emailsts_yn=emailsts_yn;
			this.zipcode=zipcode ;
			this.roadAddress=roadAddress;
			this.jibunAddress=jibunAddress;
			this.namujiAddress=namujiAddress;
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class MemberLoginRequestDto{
		private String memberId;
		private String memberPw;
		
		@Builder
		public MemberLoginRequestDto(String memberId,String memberPw){
			this.memberId=memberId;
			this.memberPw=memberPw;
		}
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
	@NoArgsConstructor
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
		
		@Builder
		public MemberModifyDto(String memberPw,String tel1,String tel2,String tel3,
				String hp1,String hp2,String hp3,String smssts_yn,String email1,String email2,String emailsts_yn,String zipcode,
				String roadAddress,String jibunAddress,String namujiAddress,long memberNo) {
			this.memberPw=memberPw;
			this.tel1=tel1;
			this.tel2=tel2;
			this.tel3=tel3;
			this.hp1=hp1;
			this.hp2=hp2;
			this.hp3=hp3;
			this.smssts_yn=smssts_yn;
			this.email1=email1;
			this.email2=email2;
			this.emailsts_yn=emailsts_yn;
			this.zipcode=zipcode ;
			this.roadAddress=roadAddress;
			this.jibunAddress=jibunAddress;
			this.namujiAddress=namujiAddress;
			this.memberNo=memberNo;
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class MemberFindIdDto{
		private String email1;
		private String email2;
		
		@Builder
		public MemberFindIdDto(String email1,String email2) {
			this.email1=email1;
			this.email2=email2;
		}
	}
	
	@Data
	public static class MemberResultDto{
		private long memberNo;
		private String memberId;
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
}
