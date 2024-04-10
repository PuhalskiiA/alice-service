package com.example.aliceservice.skill.services;

import org.springframework.http.ResponseEntity;

public interface OAuthService {
    ResponseEntity<String> authenticate(String code);

    String getUrl();
}
