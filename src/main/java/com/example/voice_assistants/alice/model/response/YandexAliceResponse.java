package com.example.voice_assistants.alice.model.response;

import com.example.skill.model.components.Button;
import com.example.skill.util.external_utils.SessionState;
import com.example.skill.util.external_utils.external_assistant.CustomResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

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

    @Override
    public void setButtons(List<Button> buttons) {
        response.setButtons(buttons);
    }
}
