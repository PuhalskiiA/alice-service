package com.example.voiceAssistants.alice.model.request;

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
public class YAApplication {
    //The identifier of the application instance in which the user is communicating with Alice
    @JsonProperty("application_id")
    String applicationId;
}
