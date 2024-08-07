package com.example.aliceservice.skill.calendars.calendly.model.eventTypes;

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
public class Profile {
    @JsonProperty("type")
    String type;

    @JsonProperty("name")
    String name;

    @JsonProperty("owner")
    String owner;
}
