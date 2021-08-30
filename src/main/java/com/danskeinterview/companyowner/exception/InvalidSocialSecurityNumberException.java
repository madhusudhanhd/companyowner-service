package com.danskeinterview.companyowner.exception;

import java.text.MessageFormat;

public class InvalidSocialSecurityNumberException extends RuntimeException {

	public InvalidSocialSecurityNumberException(String ssnNumber) {
		super(MessageFormat.format("Social Security Number {0} is INVALID", ssnNumber));
	}
	
}
