package com.example.calendars.calendly.model.eventTypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventTypeCustomQuestion {
    @JsonProperty("name")
    String name;

    @JsonProperty("type")
    String type;

    @JsonProperty("position")
    Integer position;

    @JsonProperty("enabled")
    boolean enabled;

    @JsonProperty("required")
    boolean required;

    //array[string] required
    @JsonProperty("answer_choices")
    List<String> answerChoices;

    @JsonProperty("include_other")
    boolean includeOther;
}
