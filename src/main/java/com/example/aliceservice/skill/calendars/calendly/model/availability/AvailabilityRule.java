package com.example.aliceservice.skill.calendars.calendly.model.availability;

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
    @JsonProperty("type")
    String type;

    @JsonProperty("intervals")
    List<Interval> intervals;

    @JsonProperty("wday")
    String wday;

    @JsonProperty("date")
    String date;
}
