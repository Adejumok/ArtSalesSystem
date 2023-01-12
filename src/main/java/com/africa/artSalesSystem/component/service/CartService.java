package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.AddArtToCartRequest;
import com.africa.artSalesSystem.component.dto.request.AddCartRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtToCartResponse;
import com.africa.artSalesSystem.component.dto.response.AddCartResponse;
import com.africa.artSalesSystem.component.models.Cart;

import java.util.List;

public interface CartService {
    AddCartResponse addCart(String cartId, AddCartRequest addCartRequest);
    AddArtToCartResponse addArtToCart(AddArtToCartRequest cartRequest);
    List<Cart> getCartList();
    Cart save(Cart cart);

}
