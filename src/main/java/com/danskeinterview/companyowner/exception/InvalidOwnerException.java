package com.danskeinterview.companyowner.exception;

import java.text.MessageFormat;

public class InvalidOwnerException extends RuntimeException {

	public InvalidOwnerException(String ownerName, String companyName) {
		super(MessageFormat.format("Owner {0} is already associated with company {1}", ownerName, companyName));
	}
	
}
