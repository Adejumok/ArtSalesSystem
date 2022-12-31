package com.africa.artSalesSystem.component.dto.request;

import com.africa.artSalesSystem.component.models.enums.ArtType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditArtRequest {
    private Long id;
    private String artTitle;
    private ArtType artType;
    private BigDecimal artPrice;
    private String artDescription;
}
