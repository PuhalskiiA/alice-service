package com.example.aliceservice.skill.model.alice.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    //Normalised query text
    String command;

    //Full text of the user request. May contain ping.
    @JsonProperty("original_utterance")
    String originalUtterance;

    //Input type
    YARequestType type;

    //Dangerous content
    YARequestMarkup markup;

    //Words and namend entities
    YANaturalLanguageUnderstanding nlu;
}
