package com.africa.artSalesSystem.component.dto.request;

import com.africa.artSalesSystem.component.models.enums.ArtType;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddArtRequest {
    private String artTitle;
    private ArtType artType;
    private BigDecimal artPrice;
    private String artDescription;
}
