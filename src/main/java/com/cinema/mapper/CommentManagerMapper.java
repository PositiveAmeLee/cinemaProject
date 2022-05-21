package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.CommentManagerResultMap;
import com.cinema.domain.Criteria;

public interface CommentManagerMapper {

	public List<CommentManagerResultMap> commentManagerList(Criteria cri);
	
	public int commentManagerGetTotalCount();
	
	public boolean commentManagerDelete(long commentNo);
	
}
