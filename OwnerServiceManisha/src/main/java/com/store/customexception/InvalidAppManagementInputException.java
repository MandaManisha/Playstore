package com.store.customexception;

public class InvalidAppManagementInputException extends RuntimeException {
    public InvalidAppManagementInputException(String message) {
        super(message);
    }
}
