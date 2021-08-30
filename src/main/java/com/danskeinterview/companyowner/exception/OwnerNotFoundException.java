package com.danskeinterview.companyowner.exception;

import java.text.MessageFormat;

public class OwnerNotFoundException extends RuntimeException{

	public OwnerNotFoundException(Long id) {
		super(MessageFormat.format("Could not find owner with id: {0}", id));
	}
}
