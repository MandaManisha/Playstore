package com.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.store.customexception.AppManagementAlreadyExistsException;
import com.store.customexception.AppManagementNotFoundException;
import com.store.customexception.ApplicationNotFoundException;
import com.store.customexception.InvalidAppManagementInputException;
import com.store.customexception.InvalidOwnerInputException;
import com.store.customexception.OwnerAlreadyExistsException;
import com.store.customexception.OwnerNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOwnerNotFoundException(OwnerNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidOwnerInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidOwnerInputException(InvalidOwnerInputException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(OwnerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleOwnerAlreadyExistsException(OwnerAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AppManagementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAppManagementNotFoundException(AppManagementNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidAppManagementInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAppManagementInputException(InvalidAppManagementInputException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppManagementAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAppManagementAlreadyExistsException(AppManagementAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

class ErrorResponse {
    private String message;
    private int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
