package com.cinema.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.MemberDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testMapper() {
		log.info(memberMapper);
	}
	
	@Test
	public void testLogin() {
		MemberDto.MemberLoginRequestDto requestDto = MemberDto.MemberLoginRequestDto.builder()
				.memberId("gg")
				.memberPw("gg")
				.build();
		MemberDto.MemberLoginResponseDto responseDto = memberMapper.login(requestDto);
		log.info(responseDto);
	}
	
	@Test
	public void testMemberJoin() {
		MemberDto.MemberCreateDto createDto = MemberDto.MemberCreateDto.builder()
				.memberId("testMemberId")
				.memberPw("testMemberPw")
				.memberName("testmemberName")
				.memberGender("101")
				.memberBirth_y("2000")
				.memberBirth_m("10")
				.memberBirth_d("1")
				.memberBirth_gn("2")
				.tel1("")
				.tel2("")
				.tel3("")
				.hp1("010")
				.hp2("2222")
				.hp3("2222")
				.smssts_yn("Y")
				.email1("testEmail")
				.email2("test.com")
				.emailsts_yn("Y")
				.zipcode("02107")
				.roadAddress("서울 중랑구 동일로 123길 49")
				.jibunAddress("서울 중랑구 중화동 313-17")
				.namujiAddress("1층")
				.build();
		int result = memberMapper.memberJoin(createDto);
		log.info(result);
	}
	
	@Test
	public void testMemberModify() {
		MemberDto.MemberModifyDto modifyDto = MemberDto.MemberModifyDto.builder()
				.memberPw("testMemberPw")
				.tel1("")
				.tel2("")
				.tel3("")
				.hp1("010")
				.hp2("3333")
				.hp3("3333")
				.smssts_yn("Y")
				.email1("modifyEmail")
				.email2("modify.com")
				.emailsts_yn("Y")
				.zipcode("02107")
				.roadAddress("M서울 중랑구 동일로 123길 49")
				.jibunAddress("M서울 중랑구 중화동 313-17")
				.namujiAddress("M1층")
				.memberNo(4L)
				.build();
		int result = memberMapper.memberModify(modifyDto);
		log.info(result);
	}
	
	@Test
	public void testOverlapped() {
		String memberId = "gg";
		String result = memberMapper.overlapped(memberId);
		log.info(result);
	}
	
	@Test
	public void testFindId() {
		MemberDto.MemberFindIdDto findIdDto= MemberDto.MemberFindIdDto.builder()
				.email1("modifyEmail")
				.email2("modify.com")
				.build();
		List<String> result = memberMapper.findId(findIdDto);
		log.info(result);
	}
}
