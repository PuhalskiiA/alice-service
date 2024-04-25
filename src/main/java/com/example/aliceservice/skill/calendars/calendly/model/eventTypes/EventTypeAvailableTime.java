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
public class EventTypeAvailableTime {
    @JsonProperty("status")
    String status;

    @JsonProperty("invitees_remaining")
    Integer inviteesRemaining;

    @JsonProperty("start_time")
    Date startTime;

    @JsonProperty("scheduling_url")
    String schedulingURL;
}
