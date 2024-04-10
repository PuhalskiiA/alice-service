package com.example.aliceservice.skill.model.alice;

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
public class YASkillRequest {
    String command;

    @JsonProperty("original_utterance")
    String originalUtterance;

    YARequestType type;

    YARequestMarkup markup;

    YANaturalLanguageUnderstanding nlu;
}
