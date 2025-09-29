package com.example.domain;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TM_TR_LECUTURER")
public class LecturerEntity {

	@Column(name = "LECNUMBER")
	private String lecNumber;

	@Column(name = "NAME")
	private String name;

	@Column(name = "FURIGANA")
	private String furigana;

	@Column(name = "STARTLECTURER")
	private String srartLecturer;
}
