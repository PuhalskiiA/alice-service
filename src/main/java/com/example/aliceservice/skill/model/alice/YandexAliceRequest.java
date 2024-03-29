package com.example.aliceservice.skill.model.alice;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(required = true)
    YASkillRequest request;

    @ApiModelProperty(required = true)
    YASession session;

    @ApiModelProperty(required = true)
    String version;

}
