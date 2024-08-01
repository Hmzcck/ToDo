package main.java.com.hamzacicek.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest400Exception extends RuntimeException{

    public BadRequest400Exception(String message) {
        super(message);
    }
}