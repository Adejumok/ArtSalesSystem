package com.africa.artSalesSystem.models;

import com.africa.artSalesSystem.models.enums.ArtType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Art {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long artId;
    private String artTitle;
    @Enumerated
    private ArtType artType;
    private BigDecimal artPrice;
    private String artDescription;
}
