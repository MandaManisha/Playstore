package com.store.customexception;

public class AppManagementNotFoundException extends RuntimeException {
    public AppManagementNotFoundException(String message) {
        super(message);
    }
}
