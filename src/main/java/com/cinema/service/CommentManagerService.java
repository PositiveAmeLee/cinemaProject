package com.cinema.service;

import java.util.List;

import com.cinema.domain.CommentManagerResultMap;
import com.cinema.domain.Criteria;

public interface CommentManagerService {

	public List<CommentManagerResultMap> commentManagerList(Criteria cri);

	public int commentManagerGetTotalCount();

	public boolean commentManagerDelete(long commentNo);

}
