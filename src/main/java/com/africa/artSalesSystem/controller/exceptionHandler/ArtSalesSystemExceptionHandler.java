package com.africa.artSalesSystem.controller.exceptionHandler;

import com.africa.artSalesSystem.exception.CustomerAlreadyExistException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ArtSalesSystemExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<?> handleCustomerAlreadyExistException(CustomerAlreadyExistException customerAlreadyExistException){
        ApiError apiError = ApiError.builder()
                .message(customerAlreadyExistException.getMessage())
                .successful(false)
                .statusCode(customerAlreadyExistException.getStatusCode())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatusCode()));
    }
    @ExceptionHandler(UnirestException.class)
    public ResponseEntity<?> handleUnirestException( UnirestException unirestException){
        ApiError apiError = ApiError.builder()
                .message(unirestException.getMessage())
                .successful(false)
                .statusCode(400)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatusCode()));
    }
}
