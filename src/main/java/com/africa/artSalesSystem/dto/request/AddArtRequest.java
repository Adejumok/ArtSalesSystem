package com.africa.artSalesSystem.dto.request;

import com.africa.artSalesSystem.models.enums.ArtType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddArtRequest {
    private String artTitle;
    private ArtType artType;
    private BigDecimal artPrice;
    private String artDescription;
}
