package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location;

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
public class CustomLocation extends Location {
    @JsonProperty("type")
    String type;

    @JsonProperty("location")
    String location;
}
