package com.example.aliceservice.skill.model.entityes;

import com.example.aliceservice.skill.util.Sources;
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

    @Column(name = "organization_id")
    UUID organizationID;

    @Column(name = "source")
    String source;
}
