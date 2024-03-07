package com.spring.practice.authservice.domain.model;

public class AuthenticationResponse {

    private String token;
    private String userId;

    public AuthenticationResponse(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }
}