package com.hamzacicek.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom Exception for 403 Forbidden
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Forbidden403Exception extends RuntimeException{

    public Forbidden403Exception(String message) {
        super(message);
    }
}