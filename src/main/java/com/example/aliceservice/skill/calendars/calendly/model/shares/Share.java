package com.example.aliceservice.skill.calendars.calendly.model.shares;

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
public class Share {
    @JsonProperty("scheduling_links")
    SchedulingLinks schedulingLinks;

    @JsonProperty("share_override")
    ShareOverride shareOverride;
}
