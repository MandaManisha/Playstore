package com.store.customexception;

public class ApplicationNotFoundException extends RuntimeException{
	public ApplicationNotFoundException(String message) {
        super(message);
    }

}
