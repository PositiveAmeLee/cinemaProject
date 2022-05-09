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
public class MemberManagerDto {

	private long memberNo;
	private String memberId;
	private String memberName;
	private String memberNickname;
	private String memberBirth;
	private String memberGender;
	private short memberAuthority;
	private String memberPhone;
	private String memberTell;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	
}
