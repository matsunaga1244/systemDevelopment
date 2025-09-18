package com.example.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = { ByteCheckValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ByteCheck {

	String message() default "文字列のバイト数上限を超えています。文字列を変更してください。";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String encoding() default "UTF-8";

	int size();
}
