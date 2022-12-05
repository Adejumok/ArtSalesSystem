package com.africa.artSalesSystem.models;

import com.africa.artSalesSystem.models.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
