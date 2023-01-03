package com.cos.blog.domain.user.dto;

import lombok.Data;

@Data
public class JoinReqDto {
	public String username;
	private String password;
	private String email;
	private String address;
	
	
	public void setUsername(String username) {
		this.username=username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	
}
