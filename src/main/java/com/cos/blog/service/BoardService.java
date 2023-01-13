package com.cos.blog.service;

import java.util.List;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDao;
import com.cos.blog.domain.board.dto.DetailRespDto;
import com.cos.blog.domain.board.dto.SaveReqDto;
import com.cos.blog.domain.user.UserDao;

public class BoardService {

	private BoardDao boardDao ;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	public DetailRespDto 글상세보기(int id) {
		return boardDao.findById(id);
		
	}
	
	public int 글쓰기(SaveReqDto dto) {
		
		int result = boardDao.save(dto);
		
		return result;
	}
	
	public List<Board> 글목록보기(int page){
		return boardDao.findAll(page);
	}
	
	public int 글개수() {
		return boardDao.count();
	}
}
