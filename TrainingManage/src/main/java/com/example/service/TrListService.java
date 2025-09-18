package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.TrListEntity;
import com.example.model.TrListForm;
import com.example.repository.TrListRepository;

@Service
@Transactional
public class TrListService {

	@Autowired
	private TrListRepository trListRepository;

	public List<TrListEntity> selectTrList(TrListForm form){

		List<TrListEntity> list = trListRepository.selectTrList(form);
		if(list.size() == 0) {
			list = null;
		}
		return list;
    }
}
