package com.example.aliceservice.skill.services.OAuthService;

import org.springframework.http.ResponseEntity;

public interface OAuthService {
    ResponseEntity<String> authenticate(String code, String state);

    String getCodeURL(String state);

    ResponseEntity<String> refreshToken();
}
