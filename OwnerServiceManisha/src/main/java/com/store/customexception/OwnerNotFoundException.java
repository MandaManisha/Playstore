package com.store.customexception;

public class OwnerNotFoundException extends RuntimeException {
	public OwnerNotFoundException(String message) {
        super(message);
    }

}
