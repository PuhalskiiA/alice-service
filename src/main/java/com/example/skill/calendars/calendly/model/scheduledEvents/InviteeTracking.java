package com.example.skill.calendars.calendly.model.scheduledEvents;

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
public class InviteeTracking {
    @JsonProperty("utm_campaign")
    String utmCampaign;

    @JsonProperty("utm_source")
    String utmSource;

    @JsonProperty("utm_medium")
    String utmMedium;

    @JsonProperty("utm_content")
    String utmContent;

    @JsonProperty("utm_term")
    String utmTerm;

    @JsonProperty("salesforce_uuid")
    String salesforceUUID;
}
