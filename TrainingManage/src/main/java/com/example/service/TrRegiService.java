package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LecturerEntity;
import com.example.model.TrRegiForm;
import com.example.repository.TrRegiRepository;

@Service
@Transactional
public class TrRegiService {

	@Autowired
	private TrRegiRepository trRegiRepository;

	// 初期表示時の講師名一覧を取得
	public List<LecturerEntity> selectLecturer(){
		List<LecturerEntity> list = trRegiRepository.selectLecturer();
		return list;
    }

	public int registration(TrRegiForm form) {
		trRegiRepository.insertTrainee(form);
		return 0;
	}
}
