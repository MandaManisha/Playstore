package com.store.customexception;

public class AppManagementAlreadyExistsException extends RuntimeException {
    public AppManagementAlreadyExistsException(String message) {
        super(message);
    }
}
