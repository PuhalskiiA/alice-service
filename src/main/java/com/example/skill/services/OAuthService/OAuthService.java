package com.example.skill.services.OAuthService;

import org.springframework.http.ResponseEntity;

public interface OAuthService {
    ResponseEntity<String> authenticate(String code, String state);
    String getCodeURL(String userID);
}
