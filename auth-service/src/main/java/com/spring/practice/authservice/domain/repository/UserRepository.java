package com.spring.practice.authservice.domain.repository;

import com.spring.practice.authservice.domain.model.User;

public interface UserRepository {
    User save(User user);
    User findByUsername(String username);
    boolean existsByUsername(String username);
}