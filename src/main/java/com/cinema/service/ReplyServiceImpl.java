package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.domain.ReplyVO;
import com.cinema.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper replyMapper;

	@Override
	public ReplyVO get(Long replyNO) {
		return replyMapper.get(replyNO);
	}

	@Override
	public List<ReplyVO> getListFindByMovieNO(Long movieNO) {
		return replyMapper.getListFindByMovieNO(movieNO);
	}

	@Override
	public List<ReplyVO> getListFindByMemberNO(Long memberNO) {
		return replyMapper.getListFindByMemberNO(memberNO);
	}

	@Override
	public int register(ReplyVO replyVO) {
		return replyMapper.insert(replyVO);
	}

	@Override
	public int modify(ReplyVO replyVO) {
		return replyMapper.update(replyVO);
	}

	@Override
	public int remove(Long replyNO) {
		return replyMapper.delete(replyNO);
	}

}
