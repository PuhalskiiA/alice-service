package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location.data;

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
public class AudioConferencing {
    @JsonProperty("conferenceId")
    String conferenceId;

    @JsonProperty("dialinUrl")
    String dialinURL;

    @JsonProperty("tollNumber")
    String tollNumber;
}
