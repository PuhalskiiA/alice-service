package com.example.calendars.calendly.model.scheduledEvents;


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
public class InviteesCounter {
    @JsonProperty("total")
    String total;

    @JsonProperty("active")
    Integer active;

    @JsonProperty("limit")
    Integer limit;
}