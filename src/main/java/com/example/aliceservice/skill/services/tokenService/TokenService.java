package com.example.aliceservice.skill.services.tokenService;

import com.example.aliceservice.skill.model.entityes.Token;

import java.util.UUID;

public interface TokenService {
    Token getTokenByUserID(UUID userID);

    void updateTokenByUserID(String token, UUID userID);

    void deleteTokenByUserID(UUID userID);

    void addToken(UUID id, String token, String refreshToken, UUID userID, UUID organizationID, String source);
}
