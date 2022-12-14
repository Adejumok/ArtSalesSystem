package com.africa.artSalesSystem.component.dto.response;

import com.africa.artSalesSystem.component.models.Cart;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCartResponse {
    private String message;
    private Cart cart;
}
