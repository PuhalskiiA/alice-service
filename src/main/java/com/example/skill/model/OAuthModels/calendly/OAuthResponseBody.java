package com.example.skill.model.OAuthModels.calendly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class OAuthResponseBody {
    @JsonProperty("token_type")
    String tokenType;

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("refresh_token")
    String refreshToken;

    String scope;
    @JsonProperty("created_at")

    Long createdAt;

    @JsonProperty("expires_at")
    Long expiresAt;

    String owner;

    String organization;
}
