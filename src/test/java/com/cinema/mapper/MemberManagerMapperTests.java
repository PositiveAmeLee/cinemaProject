package com.cinema.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.Criteria;
import com.cinema.domain.MemberDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberManagerMapperTests {
	
	@Autowired
	MemberManagerMapper memberManagerMapper;
	
	@Test
	public void testMapper() {
		log.info(memberManagerMapper);
	}
	
	@Test
	public void testMemberGetListWithPaging() {
		Criteria cri = new Criteria();
		List<MemberDto.MemberResultDto> list = memberManagerMapper.memberGetListWithPaging(cri);
		log.info(list);
	}
	
	@Test
	public void testMemberGetTotalCount() {
		int result = memberManagerMapper.memberGetTotalCount();
		log.info(result);
	}
	
	@Test
	public void testMemberGet() {
		long memberNo=1L;
		MemberDto.MemberResultDto resultDto = memberManagerMapper.memberGet(memberNo);
		log.info(resultDto);
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
		boolean result = memberManagerMapper.memberModify(modifyDto);
		log.info(result);
	}
}
