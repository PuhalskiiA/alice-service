package com.example.aliceservice.skill.model.alice.response;

import com.example.aliceservice.skill.model.alice.SessionState;
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
public class YandexAliceResponse {
    //Data for answer to user
    YASkillResponse response;

    @JsonProperty("user_state_update")
    YAResponseSessionState sessionState;

    //Protocol version
    String version = "1.0";
}
