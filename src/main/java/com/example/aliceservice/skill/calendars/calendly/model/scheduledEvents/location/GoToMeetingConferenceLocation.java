package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location;

import com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location.data.GoToMeetingConferenceData;
import com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location.data.ZoomConferenceData;
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
public class GoToMeetingConferenceLocation extends Location {
    @JsonProperty("type")
    String type;

    @JsonProperty("status")
    String status;

    @JsonProperty("join_url")
    String joinURL;

    @JsonProperty("data")
    GoToMeetingConferenceData data;
}
