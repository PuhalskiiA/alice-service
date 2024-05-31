package com.example.skill.calendars.calendly.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserBusyTime {
    @JsonProperty("type")
    String type;

    @JsonProperty("start_time")
    Date startTime;

    @JsonProperty("end_time")
    Date endTime;

    @JsonProperty("event")
    Event event;
}
