package com.example.domain;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TM_MS_USER")
public class LoginEntity {

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "PASSWORD")
	private String passWord;

	@Column(name = "USER_NAME")
	private String userName;
}
