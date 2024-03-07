package com.spring.practice.authservice.domain.repository;

import com.spring.practice.authservice.domain.model.AuthenticationResponse;
import com.spring.practice.authservice.domain.model.User;

public interface AuthenticationRepository {
    AuthenticationResponse register(User request);
    AuthenticationResponse authenticate(User request);
}