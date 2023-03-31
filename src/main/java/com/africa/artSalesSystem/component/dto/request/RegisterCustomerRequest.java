package com.africa.artSalesSystem.component.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterCustomerRequest {
    private String firstName;
    private String email;
    private String password;
}
