package com.africa.artSalesSystem.exception;

import lombok.Getter;

@Getter
public class CustomerAlreadyExistException extends RuntimeException{
    private int statusCode;
    public CustomerAlreadyExistException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
