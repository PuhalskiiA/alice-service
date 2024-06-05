package com.example.voiceAssistants.alice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAUser {
    @JsonProperty("user_id")
    String userId;

    //Token for OAutn authentication
    @JsonProperty("access_token")
    String accessToken;
}
