package com.example.aliceservice.skill.services.OAuthService;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface YandexOAuthService {
    ResponseEntity<String> authenticate(String code, String state);

    String getCodeURL(String applicationID, String userID);
}
