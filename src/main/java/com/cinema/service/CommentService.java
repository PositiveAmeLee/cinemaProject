package com.cinema.service;

import java.util.List;

import com.cinema.domain.CommentDto;
import com.cinema.domain.Criteria;

public interface CommentService {

	public CommentDto.CommentResultDto get(Long commentNO);
	
	public List<CommentDto.CommentResultDto> getListFindByMovieNO(Long movieNO, Criteria cri);
	
	public List<CommentDto.CommentResultDto> getListFindByMemberNO(Long memberNO);
	
	public int register(CommentDto.CommentCreateDto createDto);
	
	public int modify(CommentDto.CommentUpdateDto updateDto);
	
	public int remove(Long commentNO);

	public int commentGetTotalCount();
}
