package com.cos.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.blog.config.DB;
import com.cos.blog.domain.user.dto.JoinReqDto;
import com.cos.blog.domain.user.dto.LoginReqDto;

public class UserDao {
	
	public User findByUsernameAndPassword(LoginReqDto dto)
	{
		String sql = "SELECT id,username,email,address FROM user WHERE username=? AND password=?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			 rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				return user;
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt,rs);
			
		}
		return null;
	}
	
	
	
	public int findByUsername(String username) {//회원 가입
		String sql = "SELECT *FROM user WHERE username=?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			
			 rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1; //중복 있어
			}
			return -1; //없어
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt,rs);
			
		}
		return -1;
		
	}
	
	
	
	
	
	public int save(JoinReqDto dto) {//회원 가입
		String sql = "INSERT INTO user(username,password,email,address,userRole,createDate) VALUES(?,?,?,?,'USER',now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4,dto.getAddress());
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
	public void update() {//회원수정
		
	}
	public void usernameCheck() {//아이디 중복 체크
		
	}
	public void findByUserId() {//회원정보보기
		
	}
}
