package com.example.calendars.calendly.model.scheduledEvents.location.data;

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
public class ZoomConferenceData {
    @JsonProperty("id")
    String id;

    @JsonProperty("settings")
    SettingsZoomConferenceData settings;

    @JsonProperty("extra")
    Extra extra;

    @JsonProperty("password")
    String password;
}
