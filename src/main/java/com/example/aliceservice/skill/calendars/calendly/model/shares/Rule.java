package com.example.aliceservice.skill.calendars.calendly.model.shares;

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
public class Rule {
    @JsonProperty("type")
    String type;

    @JsonProperty("wday")
    String wday;

    @JsonProperty("date")
    String date;

    @JsonProperty("intervals")
    List<Interval> intervals;
}
