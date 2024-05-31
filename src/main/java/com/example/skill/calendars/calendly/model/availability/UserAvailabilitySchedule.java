package com.example.skill.calendars.calendly.model.availability;

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
public class UserAvailabilitySchedule {
    @JsonProperty("uri")
    String uri;

    @JsonProperty("default")
    boolean defaultAvailabilitySchedule;

    @JsonProperty("name")
    String name;

    @JsonProperty("user")
    //URI
    String user;

    @JsonProperty("timezone")
    String timezone;

    @JsonProperty("rules")
    List<AvailabilityRule> availabilityRules;
}
