package com.example.alice.model.request;

import com.example.alice.util.SessionState;
import com.example.skill.util.external.CustomRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YandexAliceRequest extends CustomRequest {
    YAMetadata meta;

    YASkillRequest request;

    YASession session;

    @JsonProperty("state")
    YAState sessionState;

    String version;

    public String getUserCommand() {
        return request.getCommand();
    }

    public SessionState getUserSessionState() {
        return sessionState.getUserState().getState();
    }

    public String getUserPsuid() {
        return session.getUser().getUserId();
    }
}
