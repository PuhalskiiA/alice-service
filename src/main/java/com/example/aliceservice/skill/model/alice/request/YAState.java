package com.example.aliceservice.skill.model.alice.request;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.states.YAApplicationState;
import com.example.aliceservice.skill.model.alice.request.states.YASessionState;
import com.example.aliceservice.skill.model.alice.request.states.YAUserState;
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
public class YAState {
    @JsonProperty("session")
    YASessionState sessionState;

    @JsonProperty("user")
    YAUserState userState;

    @JsonProperty("application")
    YAApplicationState applicationState;
}
