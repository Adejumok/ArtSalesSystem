package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.component.service.UserService;
import com.africa.artSalesSystem.component.dto.request.RegisterCustomerRequest;
import com.africa.artSalesSystem.component.dto.response.RegisterCustomerResponse;
import com.africa.artSalesSystem.exception.CustomerAlreadyExistException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceImplTest {

    UserService customerService;
    RegisterCustomerRequest customerRequest;
    RegisterCustomerRequest customerRequest2;

    @BeforeEach
    void setUp() {
        customerRequest = RegisterCustomerRequest.builder()
                .email("adeyikarose@gmail.com")
                .firstName("Henry")
                .password("1234")
                .build();
        customerRequest2 = RegisterCustomerRequest.builder()
                .email("adeyikarose@gmail.com")
                .firstName("Ben")
                .password("abcd")
                .build();
    }

    @Test
    void registerCustomerTest() throws UnirestException {
        RegisterCustomerResponse response = customerService.registerCustomer(customerRequest);
        assertThat(response.getEmail()).isEqualTo("adeyikarose@gmail.com");
        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).isNotNull();
    }

    @Test
    void SameEmailCannotRegisterTwiceTest() throws UnirestException {
        RegisterCustomerResponse response = customerService.registerCustomer(customerRequest2);
        assertThrows(CustomerAlreadyExistException.class, ()-> customerService.registerCustomer(customerRequest2));
        assertThat(response.getEmail()).isEqualTo("adeyikarose@gmail.com");
        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).isNotNull();
    }
}