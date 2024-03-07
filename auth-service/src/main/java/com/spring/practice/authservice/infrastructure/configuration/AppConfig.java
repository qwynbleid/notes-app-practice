package com.spring.practice.authservice.infrastructure.configuration;

import com.spring.practice.authservice.domain.repository.AuthenticationRepository;
import com.spring.practice.authservice.domain.repository.UserRepository;
import com.spring.practice.authservice.domain.service.AuthenticationService;
import com.spring.practice.authservice.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
    @Bean
    public AuthenticationService authenticationService(AuthenticationRepository authenticationRepository) {
        return new AuthenticationService(authenticationRepository);
    }

}