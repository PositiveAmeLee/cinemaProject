package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.domain.CommentManagerDto;
import com.cinema.domain.Criteria;
import com.cinema.mapper.CommentManagerMapper;

@Service
public class CommentManagerServiceImpl implements CommentManagerService {
	
	CommentManagerDto commentManagerDto;
	
	@Autowired
	CommentManagerMapper commentManagerMapper;
	
	@Override
	public List<CommentManagerDto> loadMemberCommentList(long memberNo) {
		return commentManagerMapper.commentList(memberNo);
	}
	
	public int commentGetTotalCount() {
		return commentManagerMapper.commentGetTotalCount();
	}

	@Override
	public List<CommentManagerDto> loadMemberComentDetail(long commentNo) {
		return commentManagerMapper.commentDetail(commentNo);
	}

	@Override
	public boolean deleteComment(long commentNo) {
		return commentManagerMapper.commentDelete(commentNo);
	}

	@Override
	public List<CommentManagerDto> searchComment(Criteria cri) {
		return commentManagerMapper.commentSearch(cri);
	}

}
