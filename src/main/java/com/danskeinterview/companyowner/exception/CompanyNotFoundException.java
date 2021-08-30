package com.danskeinterview.companyowner.exception;

import java.text.MessageFormat;

public class CompanyNotFoundException extends RuntimeException{
	
	public CompanyNotFoundException(Long id) {
		super(MessageFormat.format("Could not find Company with id: {0}", id));
	}

}
