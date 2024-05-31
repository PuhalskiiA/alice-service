package com.example.alice.model.response;

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
public class YASkillResponse {
    //Text to be shown and voiced to the user
    String text;

    //Response in TTS (text-to-speech) format
    String tts;

    //Buttons
    List<YAButton> buttons;

    //End talk sign
    @JsonProperty("end_session")
    boolean endSession;
}
