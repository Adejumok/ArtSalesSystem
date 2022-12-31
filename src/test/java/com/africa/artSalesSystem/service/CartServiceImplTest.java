package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.component.service.ArtService;
import com.africa.artSalesSystem.component.service.CartService;
import com.africa.artSalesSystem.component.dto.request.CartRequest;
import com.africa.artSalesSystem.component.dto.response.CartResponse;
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


    @BeforeEach
    void setUp(){
        Cart cart = new Cart();
        savedCart = cartService.save(cart);

        art = Art.builder()
                .artTitle("African Art")
                .artType(ArtType.DRAWING)
                .artId(1L)
                .artPrice(BigDecimal.valueOf(12323.4))
                .build();

        artService.saveArt(art);
    }

    @Test
    @DisplayName("Test that cart can be created")
    void addArtToCartTest(){
        CartRequest cartRequest = CartRequest.builder()
                .cartId(savedCart.getId())
                .artTitle(art.getArtTitle())
                .build();

        CartResponse response = cartService.addArtToCart(cartRequest);
        log.info("{}->", response.getMessage());
        assertThat(response).isNotNull();
        assertThat(response.getCart().getSubTotal()).isGreaterThan(BigDecimal.valueOf(12000));
    }

}
