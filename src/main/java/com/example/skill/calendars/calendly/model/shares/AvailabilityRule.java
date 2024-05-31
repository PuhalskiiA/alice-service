package com.example.skill.calendars.calendly.model.shares;

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
public class AvailabilityRule {
    @JsonProperty("rules")
    List<Rule> rules;

    @JsonProperty("timezone")
    String timezone;
}
