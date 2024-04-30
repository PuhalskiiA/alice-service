package com.example.aliceservice.skill.model.OAuthModels.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OAuthResponseUserBody {
    @JsonProperty("login")
    String login;

    @JsonProperty("id")
    String id;

    @JsonProperty("client_id")
    String clientID;

    @JsonProperty("psuid")
    String psuid;

    @JsonProperty("default_email")
    String defaultEmail;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("real_name")
    String realName;

    @JsonProperty("sex")
    String sex;
}
