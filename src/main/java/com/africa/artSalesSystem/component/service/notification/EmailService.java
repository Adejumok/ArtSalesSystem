package com.africa.artSalesSystem.component.service.notification;

import com.africa.artSalesSystem.component.dto.request.MailRequest;
import com.africa.artSalesSystem.component.dto.response.MailResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.concurrent.CompletableFuture;

public interface EmailService {
    CompletableFuture<MailResponse> sendSimpleMail(MailRequest mailRequest) throws UnirestException;
}
