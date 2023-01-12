package com.africa.artSalesSystem.component.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCartRequest {
    private BigDecimal subTotal = BigDecimal.ZERO;
}
