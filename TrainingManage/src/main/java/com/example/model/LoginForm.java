package com.example.model;

import com.example.validation.ByteCheck;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {

	@ByteCheck(size = 50)
	@NotEmpty
	private String userId;

	@ByteCheck(size = 10)
	@NotEmpty
	private String passWord;

	private String userName;
}
