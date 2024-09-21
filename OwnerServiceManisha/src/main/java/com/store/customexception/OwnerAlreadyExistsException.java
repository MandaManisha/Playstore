package com.store.customexception;

public class OwnerAlreadyExistsException extends RuntimeException {
	public OwnerAlreadyExistsException(String message) {
        super(message);
    }

}
