package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.dto.request.RegisterCustomerRequest;
import com.africa.artSalesSystem.dto.response.RegisterCustomerResponse;
import com.africa.artSalesSystem.models.ArtSystemUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);
    public ArtSystemUser findByEmail(String email);
}
