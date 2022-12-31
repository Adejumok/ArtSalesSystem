package com.africa.artSalesSystem.component.repositories;

import com.africa.artSalesSystem.component.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
