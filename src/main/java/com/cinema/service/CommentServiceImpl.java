package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.CommentDto;
import com.cinema.domain.Criteria;
import com.cinema.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //생성자 주입
public class CommentServiceImpl implements CommentService {
	//@Autowired 생략 = 스프링 4.3버전 이후 지원하는 묵시적 자동 주입
	private final CommentMapper commentMapper; 

	@Override
	public CommentDto.CommentResultDto get(Long commentNO) {
		return commentMapper.get(commentNO);
	}

	@Override
	public List<CommentDto.CommentResultDto> getListFindByMovieNO(Long movieNO,Criteria cri) {
		return commentMapper.getListFindByMovieNO(movieNO);
	}

	@Override
	public List<CommentDto.CommentResultDto> getListFindByMemberNO(Long memberNO) {
		return commentMapper.getListFindByMemberNO(memberNO);
	}

	@Override
	public int register(CommentDto.CommentCreateDto createDto) {
		return commentMapper.insert(createDto);
	}

	@Override
	public int modify(CommentDto.CommentUpdateDto updateDto) {
		return commentMapper.update(updateDto);
	}

	@Override
	public int remove(Long commentNO) {
		return commentMapper.delete(commentNO);
	}

	@Override
	public int commentGetTotalCount() {
		return commentMapper.commentGetTotalCount();
	}

}
