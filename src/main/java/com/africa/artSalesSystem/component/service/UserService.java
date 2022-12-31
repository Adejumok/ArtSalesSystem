package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.RegisterCustomerRequest;
import com.africa.artSalesSystem.component.dto.response.RegisterCustomerResponse;
import com.africa.artSalesSystem.component.models.ArtSystemUser;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) throws UnirestException;
    public ArtSystemUser findByEmail(String email);
}
