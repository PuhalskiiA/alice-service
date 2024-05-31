package com.example.alice.model.response;

import com.example.alice.util.SessionState;
import com.example.skill.util.external.CustomResponse;
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
public class YandexAliceResponse extends CustomResponse {
    //Data for answer to user
    YASkillResponse response;

    @JsonProperty("user_state_update")
    YAResponseSessionState sessionState;

    //Protocol version
    String version = "1.0";

    @Override
    public void setText(String text) {
        response.setText(text);
    }

    @Override
    public void setState(SessionState state) {
        sessionState.setValue(state);
    }
}
