package com.cinema.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberManagerDto {

	private long memberNo;
	private String memberId;
	private String memberName;
	private String memberNickname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date memberBirth;
	private String memberGender;
	private String memberEmail;
	private String memberAuthority;
	private String memberPhone;
	private String memberTell;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	
}
