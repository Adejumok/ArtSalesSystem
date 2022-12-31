package com.africa.artSalesSystem.component.dto.request;

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
