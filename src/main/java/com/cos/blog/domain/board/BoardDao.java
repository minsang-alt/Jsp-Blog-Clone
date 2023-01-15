package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DB;
import com.cos.blog.domain.board.dto.DetailRespDto;
import com.cos.blog.domain.board.dto.SaveReqDto;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.dto.JoinReqDto;


public class BoardDao {
	
	public int deleteById(int id) {//회원 가입
		String sql = "DELETE FROM board WHERE id=?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
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
	
	
	
	
	
	public int count() {
		String sql = "SELECT count(*), id FROM board";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt,rs);
			
		}
		return -1;
	}
	
	

	public DetailRespDto findById(int id)
	{
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("select b.id,b.title,b.content,b.readCount,b.userId,u.username ");
		sb.append("from board b inner join user u ");
		sb.append("on b.userId = u.id ");
		sb.append("where b.id=?");
		
		String sql = sb.toString();
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 0->0 ,1->4 , 2->8
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				DetailRespDto dto = new DetailRespDto();
				dto.setId(rs.getInt("b.id"));
				dto.setTitle(rs.getString("b.title"));
				dto.setContent(rs.getString("b.content"));
				dto.setReadCount(rs.getInt("b.readCount"));
				dto.setUserId(rs.getInt("b.userId"));
				dto.setUsername(rs.getString("u.username"));
				return dto;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt,rs);
			
		}
		return null;
	}
	
	
	
	
	public List<Board>findAll(int page){
		//내림차순으로 최신글이 위로 나오게 가져오기
		String sql = "SELECT * FROM board ORDER BY id DESC LIMIT ?,4";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*4); // 0->0 ,1->4 , 2->8
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
	
	
	
	public int updateReadCount(int id) {//회원 가입
		String sql = "UPDATE board SET readCount = readCount+1 where id= ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
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
