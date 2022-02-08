package com.publicissapient.creditcard.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditCardNumberValidator implements ConstraintValidator<CreditCardNumber, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		int cardSize = value.length();
		
		int sumOfDigit = 0;
		boolean isAlternateDigit = false;
		for (int i = cardSize - 1; i >= 0; i--) {

			int digitValue = value.charAt(i) - '0';

			// multiply alternate digit with 2.
			if (isAlternateDigit == true) {
				digitValue = digitValue * 2;
			}

			// for addition of digits when double digit number is present.
			sumOfDigit += digitValue / 10;
			sumOfDigit += digitValue % 10;

			isAlternateDigit = !isAlternateDigit;
		}
		if (sumOfDigit % 10 == 0) {
			return true;
		}else {
			//context.buildConstraintViolationWithTemplate("{not valid number}").addConstraintViolation();
			return false;
		}
	}

}
