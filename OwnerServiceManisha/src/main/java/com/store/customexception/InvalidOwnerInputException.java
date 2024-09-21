package com.store.customexception;

public class InvalidOwnerInputException extends RuntimeException {
	public InvalidOwnerInputException(String message) {
        super(message);
    }

}
