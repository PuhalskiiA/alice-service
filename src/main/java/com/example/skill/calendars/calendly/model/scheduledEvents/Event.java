package com.example.skill.calendars.calendly.model.scheduledEvents;

import com.example.skill.calendars.calendly.model.scheduledEvents.location.Location;
import com.example.skill.calendars.calendly.model.scheduledEvents.location.LocationParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @JsonProperty("uri")
    String uri;

    @JsonProperty("name")
    String name;

    @JsonProperty("status")
    String status;

    @JsonProperty("start_time")
    String startTime;

    @JsonProperty("end_time")
    String endTime;

    @JsonProperty("event_type")
    String eventType;

    @JsonProperty("location")
    LocationParam<? extends Location> location;

    @JsonProperty("invitees_counter")
    InviteesCounter inviteesCounter;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;

    @JsonProperty("event_memberships")
    List<EventMemberships> eventMemberships;

    @JsonProperty("event_guests")
    List<Guest> eventGuests;

    @JsonProperty("cancellation")
    Cancellation cancellation;

    @JsonProperty("calendar_event")
    CalendarEvent calendarEvent;
}
