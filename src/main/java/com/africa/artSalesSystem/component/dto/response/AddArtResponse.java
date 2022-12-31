package com.africa.artSalesSystem.component.dto.response;

import com.africa.artSalesSystem.component.models.enums.ArtType;
import lombok.*;

import java.math.BigDecimal;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddArtResponse {
    private Long artId;
    private String artTitle;
    private ArtType artType;
    private BigDecimal artPrice;
    private String artDescription;
}
