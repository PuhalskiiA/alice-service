package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents;

import com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location.Location;
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
public class Event {
    String uri;
    String name;
    String status;
    Date startTime;
    Date endTime;
    String eventType;
//    Location<? extends Location>
}
