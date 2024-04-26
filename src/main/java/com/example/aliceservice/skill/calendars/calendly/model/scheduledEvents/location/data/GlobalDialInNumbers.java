package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents.location.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
public class GlobalDialInNumbers {
    @JsonProperty("number")
    String number;

    @JsonProperty("country")
    String country;

    @JsonProperty("type")
    String type;

    @JsonProperty("city")
    String city;

    @JsonProperty("country_name")
    String countryName;
}
