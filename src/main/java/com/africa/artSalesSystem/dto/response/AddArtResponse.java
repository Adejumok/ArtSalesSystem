package com.africa.artSalesSystem.dto.response;

import com.africa.artSalesSystem.models.enums.ArtType;
import lombok.*;

import javax.persistence.Enumerated;
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
