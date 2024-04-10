package com.example.aliceservice.skill.model.alice.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YandexAliceRequest {
    //Device information
    YAMetadata meta;

    //Data from user
    YASkillRequest request;

    //Session dara
    YASession session;

    //Transmitted state when saving a session
    YARequestSessionState sessionState;

    //Protocol version
    String version;
}