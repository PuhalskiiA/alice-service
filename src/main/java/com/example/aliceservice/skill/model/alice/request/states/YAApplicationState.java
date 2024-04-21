package com.example.aliceservice.skill.model.alice.request.states;

import com.example.aliceservice.skill.model.alice.SessionState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAApplicationState {
    SessionState state;
}
