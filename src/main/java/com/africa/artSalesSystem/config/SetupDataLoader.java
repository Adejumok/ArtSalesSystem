package com.africa.artSalesSystem.config;

import com.africa.artSalesSystem.models.ArtSystemUser;
import com.africa.artSalesSystem.models.enums.RoleType;
import com.africa.artSalesSystem.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (userRepository.findByEmail("adminuser@gmail.com").isEmpty()){
            ArtSystemUser user = new ArtSystemUser("Admin", "User","adminuser@gmail.com", passwordEncoder.encode("password1234#"), RoleType.ROLE_ADMIN);
            userRepository.save(user);
        }
    }
}