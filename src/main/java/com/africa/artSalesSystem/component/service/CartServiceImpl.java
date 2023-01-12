package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.AddArtToCartRequest;
import com.africa.artSalesSystem.component.dto.request.AddCartRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtToCartResponse;
import com.africa.artSalesSystem.component.dto.response.AddCartResponse;
import com.africa.artSalesSystem.exception.ArtSalesSystemException;
import com.africa.artSalesSystem.component.models.Art;
import com.africa.artSalesSystem.component.models.Cart;
import com.africa.artSalesSystem.component.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ArtService artService;

    @Override
    public AddCartResponse addCart(String cartId, AddCartRequest request) {
        Optional<Cart> foundCart = cartRepository.findById(Long.valueOf(cartId));
        if (foundCart.isPresent()){
            throw new ArtSalesSystemException("Cart with id "+cartId+" already added.", 404);
        }
        Cart cart = new Cart();
        cart.setSubTotal(request.getSubTotal());
        cartRepository.save(cart);
        return AddCartResponse.builder()
                .message("Cart with id "+cartId+"added successfully.")
                .build();
    }

    @Override
    public AddArtToCartResponse addArtToCart(AddArtToCartRequest cartRequest) {
        Optional<Cart> foundCart = cartRepository.findById(cartRequest.getCartId());
        if (foundCart.isEmpty()){
            throw new ArtSalesSystemException("Cart with id "+cartRequest.getCartId()+" does not exist", 404);
        }
        Cart cart1 = foundCart.get();
        Art art = artService.findArtByArtTitle(cartRequest.getArtTitle());
        cart1.getArts().add(art);
        Cart savedCart = cartRepository.save(updateCartPriceSubTotal(cart1, art));
        return AddArtToCartResponse.builder()
                .cart(savedCart)
                .message("Art with title "+cartRequest.getArtTitle()+" successfully " +
                        "added to cart with id "+cart1.getId())
                .build();
    }

    private Cart updateCartPriceSubTotal(Cart cart, Art art){
        cart.setSubTotal(cart.getSubTotal().add(art.getArtPrice()));
        return cart;
    }

    @Override
    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }
    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}
