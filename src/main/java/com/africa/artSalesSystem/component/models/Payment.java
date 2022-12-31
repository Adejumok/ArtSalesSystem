package com.africa.artSalesSystem.component.models;

import com.africa.artSalesSystem.component.models.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long paymentId;
    @Enumerated
    private PaymentType paymentType;
    private LocalDateTime paymentTime;
    private String paymentDescription;
}
