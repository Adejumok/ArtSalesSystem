package com.africa.artSalesSystem.controller;

import com.africa.artSalesSystem.security.AuthToken;
import com.africa.artSalesSystem.component.dto.request.LoginRequest;
import com.africa.artSalesSystem.component.dto.request.RegisterCustomerRequest;
import com.africa.artSalesSystem.component.dto.response.RegisterCustomerResponse;
import com.africa.artSalesSystem.exception.ArtSalesSystemException;
import com.africa.artSalesSystem.component.models.ArtSystemUser;
import com.africa.artSalesSystem.security.jwt.TokenProvider;
import com.africa.artSalesSystem.component.service.UserService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer( @NonNull @RequestBody RegisterCustomerRequest registerCustomerRequest) throws UnirestException {
        RegisterCustomerResponse registerCustomerResponse = userService.registerCustomer(registerCustomerRequest);
        return new ResponseEntity<>(registerCustomerResponse, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws ArtSalesSystemException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateJWTToken(authentication);
        ArtSystemUser user = userService.findByEmail(loginRequest.getEmail());
        return new ResponseEntity<>(new AuthToken(token, user.getId()), HttpStatus.OK);
    }

}
