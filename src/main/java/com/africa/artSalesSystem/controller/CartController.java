package com.africa.artSalesSystem.controller;

import com.africa.artSalesSystem.component.dto.request.AddArtToCartRequest;
import com.africa.artSalesSystem.component.dto.request.AddCartRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtToCartResponse;
import com.africa.artSalesSystem.component.dto.response.AddCartResponse;
import com.africa.artSalesSystem.component.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class CartController {
    private final CartService cartService;
    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestBody String cartId, AddCartRequest request){
        AddCartResponse response = cartService.addCart(cartId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/addArtToCart")
    public ResponseEntity<?> addCartToCart(@RequestBody AddArtToCartRequest request){
        AddArtToCartResponse response = cartService.addArtToCart(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
