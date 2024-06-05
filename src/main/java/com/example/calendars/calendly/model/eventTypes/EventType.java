package com.example.calendars.calendly.model.eventTypes;

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
public class EventType {
    @JsonProperty("uri")
    String uri;

    @JsonProperty("name")
    String name;

    @JsonProperty("active")
    boolean active;

    @JsonProperty("slug")
    String slug;

    @JsonProperty("scheduling_url")
    String schedulingURL;

    @JsonProperty("duration")
    Integer duration;

    @JsonProperty("kind")
    String kind;

    @JsonProperty("pooling_type")
    String poolingType;

    @JsonProperty("type")
    String type;

    @JsonProperty("colour")
    String colour;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;

    @JsonProperty("internal_note")
    String internalNote;

    @JsonProperty("description_plain")
    String descriptionPlain;

    @JsonProperty("description_html")
    String descriptionHTML;

    @JsonProperty("profile")
    Profile profile;

    @JsonProperty("secret")
    boolean secret;

    @JsonProperty("booking_method")
    String bookingMethod;

    @JsonProperty("custom_questions")
    EventTypeCustomQuestion customQuestions;

    @JsonProperty("deleted_at")
    String deletedAt;

    @JsonProperty("admin_managed")
    boolean adminManaged;

    @JsonProperty("locations")
    //Must be array[object] not string
    String locations;

    @JsonProperty("position")
    Integer position;
}
