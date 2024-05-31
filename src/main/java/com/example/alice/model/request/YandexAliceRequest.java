package com.example.alice.model.request;

import com.example.alice.util.SessionState;
import com.example.skill.util.external.CustomRequest;
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
public class YandexAliceRequest extends CustomRequest {
    //Device information
    YAMetadata meta;

    //Data from user
    YASkillRequest request;

    //Session data
    YASession session;

    @JsonProperty("state")
    //Transmitted state when saving a session
    YAState sessionState;

    //Protocol version
    String version;

    @Override
    public String getUserCommand() {
        return request.getCommand();
    }

    @Override
    public SessionState getUserSessionState() {
        return sessionState.getUserState().getState();
    }

    @Override
    public String getUserPsuid() {
        return session.getUser().getUserId();
    }
}
