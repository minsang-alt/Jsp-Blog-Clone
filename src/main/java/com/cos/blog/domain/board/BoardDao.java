package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DB;
import com.cos.blog.domain.board.dto.SaveReqDto;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.dto.JoinReqDto;

public class BoardDao {
	
	public List<Board>findAll(){
		//내림차순으로 최신글이 위로 나오게 가져오기
		String sql = "SELECT * FROM board ORDER BY id DESC";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Board> boards = new ArrayList<>();
			while(rs.next()) { 
				Board board = Board.builder()
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.content(rs.getString("title"))
						.readCount(rs.getInt("readCount"))
						.userId(rs.getInt("userId"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				boards.add(board);
			}
			return boards;
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt,rs);
			
		}
		return null;
	}
	
	public int save(SaveReqDto dto) {//회원 가입
		String sql = "INSERT INTO board(userId,title,content,createDate) VALUES(?,?,?,now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getUserId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
			int result = pstmt.executeUpdate();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt,null);
			
		}
		return -1;
		
	}
}
