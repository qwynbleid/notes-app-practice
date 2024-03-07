package com.spring.practice.authservice.domain.service;

import com.spring.practice.authservice.domain.model.User;
import com.spring.practice.authservice.domain.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public boolean existsByUsername(String username) { return userRepository.existsByUsername(username); }

}
