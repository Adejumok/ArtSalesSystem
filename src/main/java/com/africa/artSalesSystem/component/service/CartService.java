package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.CartRequest;
import com.africa.artSalesSystem.component.dto.response.CartResponse;
import com.africa.artSalesSystem.component.models.Cart;

import java.util.List;

public interface CartService {
    CartResponse addArtToCart(CartRequest cartRequest);
    List<Cart> getCartList();
    Cart save(Cart cart);

}
