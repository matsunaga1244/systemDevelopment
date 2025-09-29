package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LecturerEntity;
import com.example.repository.TrRegiRepository;

@Service
@Transactional
public class TrRegiService {

	@Autowired
	private TrRegiRepository trRegiRepository;

	public List<LecturerEntity> selectLecturer(){
		List<LecturerEntity> list = trRegiRepository.selectLecturer();
		return list;
    }
}
