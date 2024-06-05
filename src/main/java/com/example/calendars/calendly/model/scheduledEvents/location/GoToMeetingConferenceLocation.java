package com.example.calendars.calendly.model.scheduledEvents.location;

import com.example.calendars.calendly.model.scheduledEvents.location.data.GoToMeetingConferenceData;
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
