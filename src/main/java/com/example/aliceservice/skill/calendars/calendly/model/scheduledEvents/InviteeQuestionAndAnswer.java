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
public class InviteeQuestionAndAnswer {
    @JsonProperty("question")
    String question;

    @JsonProperty("answer")
    String answer;

    @JsonProperty("position")
    Integer position;
}
