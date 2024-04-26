package com.example.aliceservice.skill.calendars.calendly.model.schedulingLinks;

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
public class SchedulingLinkResponse {
    @JsonProperty("resource")
    Resource resource;
}
