package com.cinema.mapper;

import java.util.List;

import com.cinema.domain.CommentDto;

public interface CommentMapper {

	public CommentDto.CommentResultDto get(Long commentNO);
	
	public List<CommentDto.CommentResultDto> getListFindByMovieNO(Long movieNO);
	
	public List<CommentDto.CommentResultDto> getListFindByMemberNO(Long memberNO);
	
	public int insert(CommentDto.CommentCreateDto createDto);
	
	public int update(CommentDto.CommentUpdateDto updateDto); 
	
	public int delete(Long commentNO);

	public int commentGetTotalCount();
	
}
