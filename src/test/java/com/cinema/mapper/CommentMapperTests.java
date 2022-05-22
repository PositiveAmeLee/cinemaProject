package com.cinema.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cinema.domain.CommentDto;
import com.cinema.domain.CommentDto.CommentCreateDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentMapperTests {

	@Autowired
	private CommentMapper commentMapper;

	@Test
	public void testMapper() {
		log.info(commentMapper);
	}

	@Test
	public void TestGet() {
		Long commentNO = 1L;
		CommentDto.CommentResultDto result = commentMapper.get(commentNO);
		log.info(result);
	}

	@Test
	public void TestInsert() {
		CommentDto.CommentCreateDto createDto = new CommentDto.CommentCreateDto().builder().memberNo(1L).movieNO(1L)
				.commentContents("commentContents for Test").commentStarRating(10L).movieTitle("movieTitle for Test")
				.memberId("memberId for Test").memberName("memberName for Test")
				.memberNickName("memberNickName for Test").build();
		int result = commentMapper.insert(createDto);
		log.info(result);
	}

	@Test
	public void TestDelete() {
		Long commnetNO = 1L;
		int result = commentMapper.delete(commnetNO);
		log.info(result);
	}

	@Test
	public void TestUpdate() {
		CommentDto.CommentUpdateDto updateDto = new CommentDto.CommentUpdateDto().builder().commentNo(1L)
				.commentContents("updated commentsContents for Test").commentStarRating(10L).build();
		int result = commentMapper.update(updateDto);
		log.info(result);
	}

}
