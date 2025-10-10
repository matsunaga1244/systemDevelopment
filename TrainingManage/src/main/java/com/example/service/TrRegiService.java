package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LecturerEntity;
import com.example.domain.TrListEntity;
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
		TrListEntity entity = new TrListEntity();
		entity.setPcNumber(form.getPcNumber());
		entity.setName(form.getName());
		entity.setGender(form.getGender());
		entity.setFurigana(form.getFurigana());
		entity.setNewhalfway(form.getNewhalfWay());
		entity.setTrainingStart(form.getTrainingStart());
		entity.setLecturerName(form.getLecNumber());

		trRegiRepository.insertTrainee(entity);
		return 0;
	}
}
