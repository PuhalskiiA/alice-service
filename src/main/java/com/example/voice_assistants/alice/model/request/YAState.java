package com.example.voice_assistants.alice.model.request;

import com.example.voice_assistants.alice.model.request.states.YAApplicationState;
import com.example.voice_assistants.alice.model.request.states.YASessionState;
import com.example.voice_assistants.alice.model.request.states.YAUserState;
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