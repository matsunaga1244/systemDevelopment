package com.example.domain;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TM_TR_TRAINEE")
public class TrListEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "FURIGANA")
	private String furigana;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "NEWHALFWAY")
	private String newhalfway;

	@Column(name = "TRAININGSTART")
	private String trainingStart;

	@Column(name = "PCNUMBER")
	private String pcNumber;

	@Column(name = "STE2PASSE")
	private String step2Pass;

	@Column(name = "LECTURERNAME")
	private String lecturerName;
}
