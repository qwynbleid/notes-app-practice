package com.spring.practice.authservice.infrastructure.security.repository;

import com.spring.practice.authservice.domain.model.AuthenticationResponse;
import com.spring.practice.authservice.domain.model.User;
import com.spring.practice.authservice.domain.repository.AuthenticationRepository;
import com.spring.practice.authservice.infrastructure.persistence.MongoUserRepository;
import com.spring.practice.authservice.infrastructure.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class MongoAuthenticationRepository implements AuthenticationRepository {
    private final MongoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public MongoAuthenticationRepository(MongoUserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse register(User request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User with this username is already exists");
        }
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole(request.getRole());
        request.setRole("USER");
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User createdUser = userRepository.save(request);

        String token = jwtService.generateToken(request);
        return new AuthenticationResponse(token, createdUser.getId());
    }
    @Override
    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername());

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token, user.getId());

    }
}
