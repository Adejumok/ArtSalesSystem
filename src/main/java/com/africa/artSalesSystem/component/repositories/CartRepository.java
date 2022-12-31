package com.africa.artSalesSystem.component.repositories;

import com.africa.artSalesSystem.component.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
