package com.africa.artSalesSystem.controller;

import com.africa.artSalesSystem.component.dto.request.CartRequest;
import com.africa.artSalesSystem.component.dto.response.CartResponse;
import com.africa.artSalesSystem.component.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    @PostMapping("/addArtToCart")
    public ResponseEntity<?> addCartToCart(@RequestBody CartRequest request){
        CartResponse response = cartService.addArtToCart(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
