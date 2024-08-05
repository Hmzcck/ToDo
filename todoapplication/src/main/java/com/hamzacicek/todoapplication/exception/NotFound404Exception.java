package com.hamzacicek.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom Exception for 404 Not Found
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound404Exception extends  RuntimeException{
    public NotFound404Exception(String message) {
        super(message);
    }
}