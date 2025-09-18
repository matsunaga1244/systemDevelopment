package com.example.model;

import com.example.validation.ByteCheck;

import lombok.Data;

@Data
public class TrListForm {

	@ByteCheck(size = 50)
	private String name;

	@ByteCheck(size = 50)
	private String furigana;

	private String newHalfway;

	private String trainingStart;
}
