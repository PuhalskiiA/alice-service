package com.example.aliceservice.skill.calendars.calendly.OAuth.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OAuthRequestBody {
    String contentType;
    String grantType;
    String code;
    String URI;
}
