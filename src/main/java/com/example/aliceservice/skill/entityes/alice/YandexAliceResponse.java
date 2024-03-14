package com.example.aliceservice.skill.entityes.alice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data@FieldDefaults(level = AccessLevel.PRIVATE)
public class YandexAliceResponse {

    @ApiModelProperty(required = true)
    YASkillResponse response;

    @ApiModelProperty(required = true)
    String version = "1.0";

}
