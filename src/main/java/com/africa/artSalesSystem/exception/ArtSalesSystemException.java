package com.africa.artSalesSystem.exception;

import lombok.Getter;

@Getter
public class ArtSalesSystemException extends RuntimeException{
    private int statusCode;
    public ArtSalesSystemException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
