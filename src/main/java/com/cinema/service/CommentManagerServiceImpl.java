package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.CommentManagerResultMap;
import com.cinema.domain.Criteria;
import com.cinema.mapper.CommentManagerMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class CommentManagerServiceImpl implements CommentManagerService {
	
	@Autowired(required = false)
	private CommentManagerMapper commentManagerMapper;
	
	@Override
	public List<CommentManagerResultMap> commentManagerList(Criteria cri) {
		return commentManagerMapper.commentManagerList(cri);
	}
	
	public int commentManagerGetTotalCount() {
		return commentManagerMapper.commentManagerGetTotalCount();
	}

	@Override
	public boolean commentManagerDelete(long commentNo) {
		return commentManagerMapper.commentManagerDelete(commentNo);
	}

}
