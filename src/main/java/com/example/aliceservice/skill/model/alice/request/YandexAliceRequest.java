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

    //Protocol version
    String version;
}
