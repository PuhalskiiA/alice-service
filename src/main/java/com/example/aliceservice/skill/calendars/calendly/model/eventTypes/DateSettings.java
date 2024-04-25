package com.example.aliceservice.skill.calendars.calendly.model.eventTypes;

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
public class DateSettings {
    @JsonProperty("type")
    String type;

    @JsonProperty("start_date")
    Date startDate;

    @JsonProperty("end_date")
    Date endDate;
}
