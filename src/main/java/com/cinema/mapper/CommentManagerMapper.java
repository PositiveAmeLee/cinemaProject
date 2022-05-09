package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.CommentManagerDto;
import com.cinema.domain.Criteria;

public interface CommentManagerMapper {

	public List<CommentManagerDto> commentList(long memberNo);
	
	public int commentGetTotalCount();
	
	public List<CommentManagerDto> commentDetail(long commentNo);
	
	public List<CommentManagerDto> commentSearch(Criteria cri);
	
	public boolean commentDelete(long commentNo);
	
	
}
