package com.example.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.domain.TrListEntity;
import com.example.model.TrListForm;

@ConfigAutowireable
@Dao
public interface TrListRepository {
	@Select
	List<TrListEntity> selectTrList(TrListForm form);
}
