package com.example.aliceservice.skill.repositories;

import com.example.aliceservice.skill.model.entityes.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {

    Token getTokenByUserID(UUID userID);

    @Query(value = "UPDATE tokens SET token = ?1 where user_id = ?2", nativeQuery = true)
    void updateTokenByUserID(String token, UUID userId);

    void deleteTokenByUserID(UUID userID);

    @Query(value = "insert into tokens values (?, ?, ?, ?, ?)", nativeQuery = true)
    void addToken(UUID id, String token, String refreshToken, UUID userID, UUID organizationID, String source);
}
