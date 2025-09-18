package com.example.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateCheckValidator implements ConstraintValidator<DateCheck, String>{

	public boolean isValid(String value, ConstraintValidatorContext context) {

		boolean result = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		if(value != null && !value.equals("")) {
			try {
				sdf.parse(value);
			} catch(ParseException e) {
				result = false;
			}
		}
		return result;
	}
}
