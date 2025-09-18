package com.example.validation;

import java.io.UnsupportedEncodingException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ByteCheckValidator implements ConstraintValidator<ByteCheck, String>{

	private String encoding;

	private int size;

	public void initialize(ByteCheck annotation) {
		this.encoding = annotation.encoding();
		this.size = annotation.size();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {

		boolean result = true;
		if(value != null) {
			try {
				byte[] bytes = value.getBytes(encoding);
				if(bytes.length > size) {
					result = false;
				}
			} catch(UnsupportedEncodingException e) {
				result = false;
			}
		}

		return result;
	}
}
