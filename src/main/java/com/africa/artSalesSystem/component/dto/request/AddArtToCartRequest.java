package com.africa.artSalesSystem.component.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddArtToCartRequest {
    private Long cartId;
    private String artTitle;
}
