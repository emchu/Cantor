package com.example.cantor.exeption.handler;

import com.example.cantor.exeption.APIErrorResponse;
import com.example.cantor.exeption.NBPResponseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public abstract class ControllerExceptionHandler {

    @Getter
    protected String errorMessage;

    @ExceptionHandler(NBPResponseException.class)
    public ResponseEntity<APIErrorResponse> handleException(NBPResponseException e) {
        APIErrorResponse error = new APIErrorResponse(HttpStatus.NOT_FOUND, getErrorMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
