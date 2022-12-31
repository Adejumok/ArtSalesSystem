package com.africa.artSalesSystem.component.models;

import com.africa.artSalesSystem.component.models.enums.ArtType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Art {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long artId;
    private String artTitle;
    @Enumerated
    private ArtType artType;
    private BigDecimal artPrice = BigDecimal.ZERO;
    private String artDescription;
    private String imageUrl;
}
