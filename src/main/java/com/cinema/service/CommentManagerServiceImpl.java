package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.CommentDto;
import com.cinema.domain.Criteria;
import com.cinema.mapper.CommentManagerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor //생성자 주입
public class CommentManagerServiceImpl implements CommentManagerService {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final CommentManagerMapper commentManagerMapper;
	
	@Override
	public List<CommentDto.CommentResultDto> commentManagerList(Criteria cri) {
		return commentManagerMapper.commentManagerList(cri);
	}
	
	@Override
	public int commentManagerGetTotalCount() {
		return commentManagerMapper.commentManagerGetTotalCount();
	}

	@Override
	public boolean commentManagerDelete(long commentNo) {
		return commentManagerMapper.commentManagerDelete(commentNo);
	}

}
