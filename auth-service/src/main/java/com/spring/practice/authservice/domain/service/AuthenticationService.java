package com.spring.practice.authservice.domain.service;

import com.spring.practice.authservice.domain.model.AuthenticationResponse;
import com.spring.practice.authservice.domain.model.User;
import com.spring.practice.authservice.domain.repository.AuthenticationRepository;

public class AuthenticationService {
    private final AuthenticationRepository authenticationRepository;

    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public AuthenticationResponse register(User request) {
        return authenticationRepository.register(request);
    }
    public AuthenticationResponse authenticate(User request) {
        return authenticationRepository.authenticate(request);
    }

}