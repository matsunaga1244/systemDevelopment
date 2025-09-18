package com.example.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.domain.LoginEntity;

@ConfigAutowireable
@Dao
public interface LoginRepository {
	@Select
    LoginEntity selectUser(String userId,String pass);
}
