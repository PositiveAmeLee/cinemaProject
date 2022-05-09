package com.cinema.service;

import java.util.List;

import com.cinema.domain.CommentManagerDto;
import com.cinema.domain.Criteria;

public interface CommentManagerService {

	public List<CommentManagerDto> loadMemberCommentList(long memberNo);

	public int commentGetTotalCount();
	
	public List<CommentManagerDto> loadMemberComentDetail(long commentNo);

	public boolean deleteComment(long commentNo);

	public List<CommentManagerDto> searchComment(Criteria cri);
}
