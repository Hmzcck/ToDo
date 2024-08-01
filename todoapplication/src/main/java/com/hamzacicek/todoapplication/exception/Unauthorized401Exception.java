package main.java.com.hamzacicek.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class Unauthorized401Exception extends RuntimeException{

    public Unauthorized401Exception(String message) {
        super(message);
    }

}