package com.example.aliceservice.skill.calendars.calendly.model.scheduledEvents;

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
public class Cancellation {
    @JsonProperty("canceled_by")
    String canceledBy;

    @JsonProperty("reason")
    String reason;

    @JsonProperty("canceler_type")
    String cancelerType;

    @JsonProperty("created_at")
    Date createdAt;
}
