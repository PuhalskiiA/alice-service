package com.example.skill.calendars.calendly.model.scheduledEvents;

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
public class Invitee {
    @JsonProperty("uri")
    String uri;

    @JsonProperty("email")
    String email;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("name")
    String name;

    @JsonProperty("status")
    String status;

    @JsonProperty("questions_and_answers")
    List<InviteeQuestionAndAnswer> questionsAndAnswers;

    @JsonProperty("timezone")
    String timezone;

    @JsonProperty("event")
    String event;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;

    @JsonProperty("tracking")
    InviteeTracking inviteeTracking;

    @JsonProperty("text_reminder_number")
    String textReminderNumber;

    @JsonProperty("rescheduled")
    boolean rescheduled;

    @JsonProperty("old_invitee")
    String oldInvitee;

    @JsonProperty("new_invitee")
    String newInvitee;

    @JsonProperty("cancel_url")
    String cancelURL;

    @JsonProperty("reschedule_url")
    String rescheduleURL;

    @JsonProperty("routing_form_submission")
    String routingFormSubmission;

    @JsonProperty("cancellation")
    Cancellation cancellation;

    @JsonProperty("payment")
    Payment payment;

    @JsonProperty("no_show")
    NoShow noShow;

    @JsonProperty("reconfirmation")
    Reconfirmation reconfirmation;

    @JsonProperty("scheduling_method")
    String schedulingMethod;

    @JsonProperty("invitee_scheduled_by")
    String inviteeScheduledBy;
}
