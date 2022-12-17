package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.dto.request.MailRequest;
import com.africa.artSalesSystem.dto.response.MailResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.concurrent.CompletableFuture;

public interface EmailService {
    CompletableFuture<MailResponse> sendSimpleMail(MailRequest mailRequest) throws UnirestException;
}
