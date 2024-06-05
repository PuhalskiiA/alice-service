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
public class SchedulingLinks {
    @JsonProperty("booking_url")
    String bookingURL;

    @JsonProperty("owner")
    String owner;

    @JsonProperty("owner_type")
    String ownerType;
}
