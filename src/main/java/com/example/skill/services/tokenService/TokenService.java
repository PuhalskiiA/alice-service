package com.example.skill.services.tokenService;

import com.example.skill.model.entityes.Token;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenService {
    Token getTokenByUserID(UUID userID);

    void updateTokenByUserID(String token, UUID userID);

    void deleteTokenByUserID(UUID userID);

    void addToken(UUID id, String token, String refreshToken, UUID userID, String owner, String organization, String source);

    Token getTokenByUserIDAndSource(UUID userID, String source);

    Optional<Token> getTokenByPsuidAndSource(String psuid, String source);

    List<String> getSourcesByUserID(String psuid);
}
