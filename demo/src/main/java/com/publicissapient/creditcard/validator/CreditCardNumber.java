package com.publicissapient.creditcard.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreditCardNumberValidator.class)
@Documented
public @interface CreditCardNumber {

	String message() default "{credit card number is not a valid Luhn number}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
