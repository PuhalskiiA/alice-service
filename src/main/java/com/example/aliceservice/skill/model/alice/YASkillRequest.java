package com.example.aliceservice.skill.model.alice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class YASkillRequest {
    @ApiModelProperty(required = true)
    String command;
    @JsonProperty("original_utterance")
    @ApiModelProperty(required = true, name = "original_utterance")
    String originalUtterance;
    @ApiModelProperty(required = true)
    YARequestType type;
    @ApiModelProperty
    YARequestMarkup markup;
    YANaturalLanguageUnderstanding nlu;

}
