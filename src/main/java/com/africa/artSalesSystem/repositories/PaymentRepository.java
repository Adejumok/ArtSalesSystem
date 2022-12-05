package com.africa.artSalesSystem.repositories;

import com.africa.artSalesSystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
