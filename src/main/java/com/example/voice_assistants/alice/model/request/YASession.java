package com.example.voice_assistants.alice.model.request;

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
//Данные о сессии
public class YASession {
    //Message identifier in session
    @JsonProperty("message_id")
    Integer messageId;

    //Unique session identifier
    @JsonProperty("session_id")
    String sessionId;

    //Skill identifier
    @JsonProperty("skill_id")
    String skillId;

    //User data
    YAUser user;

    //Application data
    YAApplication application;

    //New session sign
    boolean isNew;
}
