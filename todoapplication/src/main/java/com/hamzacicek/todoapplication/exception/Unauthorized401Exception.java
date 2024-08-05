package com.hamzacicek.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom Exception for 401 Unauthorized
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class Unauthorized401Exception extends RuntimeException{

    public Unauthorized401Exception(String message) {
        super(message);
    }

}