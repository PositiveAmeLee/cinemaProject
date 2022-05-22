package com.cinema.service;

import java.util.List;

import com.cinema.domain.CommentDto;
import com.cinema.domain.Criteria;

public interface CommentManagerService {

	public List<CommentDto.CommentResultDto> commentManagerList(Criteria cri);

	public int commentManagerGetTotalCount();

	public boolean commentManagerDelete(long commentNo);

}
