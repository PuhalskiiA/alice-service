package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.util.Sources;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value= RetentionPolicy.RUNTIME)
public @interface CommandHandler {
    String[] commands();
    SessionState state();
}
