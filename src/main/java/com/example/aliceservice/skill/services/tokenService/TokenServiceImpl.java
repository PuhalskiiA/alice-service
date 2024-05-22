package com.example.aliceservice.skill.services.tokenService;

import com.example.aliceservice.skill.exceptions.TokenNotFoundException;
import com.example.aliceservice.skill.exceptions.UserNotFoundException;
import com.example.aliceservice.skill.model.entityes.Token;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.repositories.TokenRepository;
import com.example.aliceservice.skill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

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
    public void addToken(UUID id, String token, String refreshToken, UUID userID, String owner, String organization, String source) {
        tokenRepository.addToken(id, token, refreshToken, userID, owner, organization, source);
    }

    @Override
    public Token getTokenByUserIDAndSource(UUID userID, String source) {
        Optional<Token> tokenOpt = Optional.ofNullable(tokenRepository.getTokenByUserIDAndSource(userID, source));

        if (tokenOpt.isPresent()) {
            return tokenOpt.get();
        } else {
            throw new TokenNotFoundException("Token not found");
        }
    }

    @Override
    public Optional<Token> getTokenByPsuidAndSource(String psuid, String source) {
        return Optional.ofNullable(tokenRepository.getTokenByPsuidAndSource(psuid, source));
    }

    @Override
    public List<String> getSourcesByUserID(String psuid) {
        return tokenRepository.getSourcesByUserID(psuid);
    }
}
