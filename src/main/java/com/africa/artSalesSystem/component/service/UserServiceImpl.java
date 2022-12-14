package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.MailRequest;
import com.africa.artSalesSystem.component.dto.request.RegisterCustomerRequest;
import com.africa.artSalesSystem.component.dto.response.RegisterCustomerResponse;
import com.africa.artSalesSystem.component.models.enums.RoleType;
import com.africa.artSalesSystem.component.service.notification.EmailService;
import com.africa.artSalesSystem.exception.ArtSalesSystemException;
import com.africa.artSalesSystem.exception.CustomerAlreadyExistException;
import com.africa.artSalesSystem.component.models.Role;
import com.africa.artSalesSystem.component.models.ArtSystemUser;
import com.africa.artSalesSystem.component.repositories.UserRepository;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
 class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailService emailService;

    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) throws UnirestException {
        Optional<ArtSystemUser> foundCustomer = userRepository.findByEmail(registerCustomerRequest.getEmail());
        if(foundCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer with email "+registerCustomerRequest.getEmail()+" already exist",400);
        }
        ArtSystemUser savedCustomer = getRegisteredArtSystemUser(registerCustomerRequest);
        RegisterCustomerResponse response = new RegisterCustomerResponse();
        response.setMessage(String.format("%s registered successfully", savedCustomer.getFirstName()));
        response.setEmail(savedCustomer.getEmail());
        sendMail(registerCustomerRequest);
        return response;
    }

    private ArtSystemUser getRegisteredArtSystemUser(RegisterCustomerRequest registerCustomerRequest) {
        ArtSystemUser user = mapper.map(registerCustomerRequest, ArtSystemUser.class);
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.getRoles().add(new Role(RoleType.ROLE_USER));
        return userRepository.save(user);
    }

    private void sendMail(RegisterCustomerRequest registerCustomerRequest) throws UnirestException {
        MailRequest mailRequest = MailRequest.builder()
                .sender(System.getenv("SENDER"))
                .receiver(registerCustomerRequest.getEmail())
                .subject("Welcome to Art Sales Platform")
                .body("Hello "+ registerCustomerRequest.getFirstName()+". " +
                        "We are glad to let you know you have successfully registered")
                .build();
        emailService.sendSimpleMail(mailRequest);
    }

    @Override
    public ArtSystemUser findByEmail(String email) {
        ArtSystemUser foundUser = userRepository.findByEmail(email).orElse(null);
        if(foundUser != null){
            return foundUser;
        }
        throw new ArtSalesSystemException("Customer with email "+email+" does not exist",404);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArtSystemUser user = userRepository.findByEmail(username).orElse(null);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user.getRoles()));
        }
        throw new ArtSalesSystemException("User with email "+username+" does not exist",404);
    }
    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toSet());
    }
    }

