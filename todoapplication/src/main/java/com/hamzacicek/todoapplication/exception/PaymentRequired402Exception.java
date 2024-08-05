package com.hamzacicek.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Custom Exception for 402 Payment Required
@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class PaymentRequired402Exception extends RuntimeException{

    public PaymentRequired402Exception(String message) {
        super(message);
    }
}