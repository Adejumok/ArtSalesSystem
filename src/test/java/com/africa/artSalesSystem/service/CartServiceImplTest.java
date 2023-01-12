package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.component.dto.request.AddCartRequest;
import com.africa.artSalesSystem.component.dto.response.AddCartResponse;
import com.africa.artSalesSystem.component.service.ArtService;
import com.africa.artSalesSystem.component.service.CartService;
import com.africa.artSalesSystem.component.dto.request.AddArtToCartRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtToCartResponse;
import com.africa.artSalesSystem.component.models.Art;
import com.africa.artSalesSystem.component.models.Cart;
import com.africa.artSalesSystem.component.models.enums.ArtType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Autowired
    private ArtService artService;
    private Cart savedCart;
    private Art art;
    private AddCartRequest request;


    @BeforeEach
    void setUp(){
        Cart cart = new Cart();
        savedCart = cartService.save(cart);

        art = Art.builder()
                .artTitle("European Art")
                .artType(ArtType.FILM)
                .artId(1L)
                .artPrice(BigDecimal.valueOf(3000))
                .build();
        request = AddCartRequest.builder()
                .subTotal(BigDecimal.ZERO)
                .build();

        artService.saveArt(art);

    }

    @Test
    void addCartTest(){
        AddCartResponse response = cartService.addCart("1", request);
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Test that cart can be created")
    void addArtToCartTest(){
        AddArtToCartRequest cartRequest = AddArtToCartRequest.builder()
                .cartId(5L)
                .artTitle("Tarbnaz")
                .build();

        AddArtToCartResponse response = cartService.addArtToCart(cartRequest);
        log.info("{}->", response.getMessage());
        assertThat(response).isNotNull();
        assertThat(response.getCart().getSubTotal()).isEqualTo(BigDecimal.valueOf(700.00));
    }

}
