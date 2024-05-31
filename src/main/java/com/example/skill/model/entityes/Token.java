package com.example.skill.model.entityes;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @Column(name = "id")
    UUID id;

    @Column(name = "token")
    String token;

    @Column(name = "refresh_token")
    String refreshToken;

    @Column(name = "user_id")
    UUID userID;

    @Column(name = "owner")
    String owner;

    @Column(name = "organization")
    String organization;

    @Column(name = "source")
    String source;
}
