package com.example.voice_assistants.alice.model.request.states;

import com.example.skill.util.external_utils.SessionState;
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
public class YAUserState {
    @JsonProperty("value")
    SessionState state;
}