package com.example.calendars.calendly.model.shares;

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
public class LocationConfigurations {
    @JsonProperty("location")
    String location;

    @JsonProperty("additional_info")
    String additionalInfo;

    @JsonProperty("phone_number")
    String phoneNumber;

    @JsonProperty("position")
    Integer position;

    @JsonProperty("kind")
    String kind;
}
