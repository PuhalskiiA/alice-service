package com.example.aliceservice.skill.services.tokenService;

import com.example.aliceservice.skill.model.entityes.Token;
import com.example.aliceservice.skill.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenRepository tokenRepository;

    @Override
    public Token getTokenByUserID(UUID userID) {
        return tokenRepository.getTokenByUserID(userID);
    }

    @Override
    public void updateTokenByUserID(String token, UUID userID) {
        tokenRepository.updateTokenByUserID(token, userID);
    }

    @Override
    public void deleteTokenByUserID(UUID userID) {
        tokenRepository.deleteTokenByUserID(userID);
    }

    @Override
    public void addToken(UUID id, String token, String refreshToken, UUID userID, UUID organizationID, String source) {
        tokenRepository.addToken(id, token, refreshToken, userID, organizationID, source);
    }
}
