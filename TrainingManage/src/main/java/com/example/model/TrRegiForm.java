package com.example.model;

import com.example.validation.ByteCheck;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TrRegiForm {

	@ByteCheck(size = 50)
	@NotEmpty
	private String name;

	@ByteCheck(size = 50)
	@NotEmpty
	private String furigana;

	@NotEmpty
	private String gender;

	@NotEmpty
	private String newhalfWay;

	@NotEmpty
	private String trainingStart;

	@ByteCheck(size = 10)
	@NotEmpty
	private String pcNumber;

	@NotEmpty
	private String lecNumber;
}
