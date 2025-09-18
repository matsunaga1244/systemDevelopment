package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LoginEntity;
import com.example.model.LoginForm;
import com.example.repository.LoginRepository;

@Service
@Transactional
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public LoginEntity selectUser(LoginForm form){
		return loginRepository.selectUser(form.getUserId(),form.getPassWord());
    }
}
