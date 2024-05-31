package com.example.skill.repositories;

import com.example.skill.model.entityes.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {

    Token getTokenByUserID(UUID userID);

    @Query(value = "UPDATE tokens SET token = ?1 where user_id = ?2", nativeQuery = true)
    void updateTokenByUserID(String token, UUID userId);

    void deleteTokenByUserID(UUID userID);

    @Modifying
    @Transactional
    @Query(value = "insert into tokens (id, token, refresh_token, user_id, owner, organization, source) values (?, ?, ?, ?, ?, ?, ?)",
            nativeQuery = true)
    void addToken(UUID id, String token, String refreshToken, UUID userID, String owner, String organization, String source);

    Token getTokenByUserIDAndSource(UUID userID, String source);

    @Query(value = "select tokens.* from tokens " +
            "inner join users on tokens.user_id = users.id " +
            "where psuid = ?1 and source = ?2", nativeQuery = true)
    Token getTokenByPsuidAndSource(String psuid, String source);

    @Query(value = "select source from tokens " +
            "inner join users on tokens.user_id = users.id " +
            "where psuid = ?1", nativeQuery = true)
    List<String> getSourcesByUserID(String psuid);
}
