package com.cos.blog.domain.user;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private int id;
	private String username;
	private String email;
	private String address;
	//권한 admin,user
	private String userRole;
	private Timestamp createDate;
}
