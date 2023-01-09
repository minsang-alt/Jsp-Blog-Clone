package com.cos.blog.service;

import com.cos.blog.domain.board.BoardDao;
import com.cos.blog.domain.board.dto.SaveReqDto;
import com.cos.blog.domain.user.UserDao;

public class BoardService {

	private BoardDao boardDao ;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	public int 글쓰기(SaveReqDto dto) {
		
		int result = boardDao.save(dto);
		
		return result;
	}
}
