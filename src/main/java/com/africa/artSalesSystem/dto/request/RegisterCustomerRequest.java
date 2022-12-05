package com.africa.artSalesSystem.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterCustomerRequest {
    private String email;
    private String firstName;
    private String password;
}
