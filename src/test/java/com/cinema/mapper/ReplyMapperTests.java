package com.cinema.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cinema.domain.ReplyVO;
import com.cinema.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] movieNOArr = {1L,2L,3L,4L,5L};
	private Long[] memberNOArr = {1L,2L,3L,4L,5L};
	
	@Setter(onMethod_=@Autowired)
	private ReplyMapper replyMapper;
	
	@Test
	public void testMapper() {
		log.info(replyMapper);
	} 
	
	@Test
	public void testGet() {
		Long replyNO = 1L;
		log.info("testGet()..........replyNO: "+replyNO);
		ReplyVO replyVO = replyMapper.get(replyNO);
		log.info(replyVO);
	}
	
	@Test
	public void testGetListFindByMovieNO() {
		Long movieNO = 1L;
		log.info("testGetListFindByMovieNO()..........movieNO: "+movieNO);
		List<ReplyVO> replyLists = replyMapper.getListFindByMovieNO(movieNO);
		replyLists.forEach(reply->log.info(reply));
	}
	
	@Test
	public void testGetListFindByMemberNO() {
		Long memberNO = 1L;
		log.info("testGetListFindByMemberNO()..........memberNO: "+memberNO);
		List<ReplyVO> replyLists = replyMapper.getListFindByMemberNO(memberNO);
		replyLists.forEach(reply->log.info(reply));
	}
	
	@Test
	public void testInsert() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO replyVO = new ReplyVO();
			int randomNO = (int)(Math.random()*5)+1;
			replyVO.setMovieNO(movieNOArr[i%5]);
			replyVO.setMemberNO(memberNOArr[i%5]);
			replyVO.setTitle("댓글테스트 "+i);
			replyVO.setContent("댓글 테스트 "+i);
			replyVO.setStars(randomNO);
			replyMapper.insert(replyVO);
		});
	}
	
	@Test
	public void testUpdate() {
		Long targetRno = 10L;
		ReplyVO replyVO = replyMapper.get(targetRno);
		replyVO.setTitle("수정된 reply");
		replyVO.setContent("수정된 reply");
		int count = replyMapper.update(replyVO);
		log.info("update count: "+count);
	}
	

}
