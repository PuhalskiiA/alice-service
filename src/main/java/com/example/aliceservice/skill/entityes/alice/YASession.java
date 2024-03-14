package com.example.aliceservice.skill.entityes.alice;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class YASession {

    @ApiModelProperty(required = true)
    @JsonProperty("message_id")
    Integer messageId;

    @ApiModelProperty(required = true, name = "session_id")
    @JsonProperty("session_id")
    String sessionId;

    @ApiModelProperty(required = true)
    @JsonProperty("skill_id")
    String skillId;

    @ApiModelProperty
    YAUser user;

    @ApiModelProperty
    YAApplication application;

    @ApiModelProperty(required = true, name = "new")
    boolean isNew;

}
