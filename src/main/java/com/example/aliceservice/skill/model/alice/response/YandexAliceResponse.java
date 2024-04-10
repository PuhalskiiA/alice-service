package com.example.aliceservice.skill.model.alice.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data@FieldDefaults(level = AccessLevel.PRIVATE)
public class YandexAliceResponse {
    //Data for answer to user
    YASkillResponse response;

    //Protocol version
    String version = "1.0";
}
