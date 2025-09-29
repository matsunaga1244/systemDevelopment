package com.example.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.domain.LecturerEntity;

@ConfigAutowireable
@Dao
public interface TrRegiRepository {
	@Select
	List<LecturerEntity> selectLecturer();
}
