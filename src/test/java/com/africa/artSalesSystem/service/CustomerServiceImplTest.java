package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.dto.request.RegisterCustomerRequest;
import com.africa.artSalesSystem.dto.response.RegisterCustomerResponse;
import com.africa.artSalesSystem.exception.CustomerAlreadyExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    UserService customerService;
    RegisterCustomerRequest customerRequest;
    RegisterCustomerRequest customerRequest2;

    @BeforeEach
    void setUp() {
        customerRequest = RegisterCustomerRequest.builder()
                .email("ebuks@gmail.com")
                .firstName("Henry")
                .password("1234")
                .build();
        customerRequest2 = RegisterCustomerRequest.builder()
                .email("ebuks@gmail.com")
                .firstName("Ben")
                .password("abcd")
                .build();
    }

    @AfterEach
    void tearDown(){
    }

    @Test
    void registerCustomerTest(){
        RegisterCustomerResponse response = customerService.registerCustomer(customerRequest);
        assertThat(response.getEmail()).isEqualTo("ebuks@gmail.com");
        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).isNotNull();
    }

    @Test
    void SameEmailCannotRegisterTwiceTest(){
        RegisterCustomerResponse response = customerService.registerCustomer(customerRequest);
        assertThrows(CustomerAlreadyExistException.class, ()-> customerService.registerCustomer(customerRequest));
        assertThat(response.getEmail()).isEqualTo("ebuks@gmail.com");
        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).isNotNull();
    }
}