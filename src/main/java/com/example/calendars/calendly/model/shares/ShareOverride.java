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
public class ShareOverride {
    @JsonProperty("name")
    String name;

    @JsonProperty("duration")
    String duration;

    @JsonProperty("period_type")
    String periodType;

    @JsonProperty("start_date")
    String startDate;

    @JsonProperty("end_date")
    String endDate;

    @JsonProperty("max_booking_time")
    Integer maxBookingTime;

    @JsonProperty("hide_location")
    boolean hideLocation;

    @JsonProperty("location_configurations")
    LocationConfigurations locationConfigurations;


}
