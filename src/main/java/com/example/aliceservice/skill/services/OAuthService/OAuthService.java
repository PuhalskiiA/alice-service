package com.example.aliceservice.skill.services.OAuthService;

import org.springframework.http.ResponseEntity;

public interface OAuthService {
    ResponseEntity<String> authenticate(String code);

    String getUrl();
}
