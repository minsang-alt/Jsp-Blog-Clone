package com.cos.blog.domain.user.dto;

import lombok.Data;

@Data
public class LoginReqDto {
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username=username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}