package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents;

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
public class Payment {
    @JsonProperty("external_id")
    String externalID;

    @JsonProperty("provider")
    String provider;

    @JsonProperty("amount")
    float amount;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("terms")
    String terms;

    @JsonProperty("successful")
    boolean successful;
}
