package com.example.cantor.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class APIErrorResponse {

    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;

    public APIErrorResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
