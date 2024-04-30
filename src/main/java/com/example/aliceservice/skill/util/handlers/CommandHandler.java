package com.example.aliceservice.skill.util.handlers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value= RetentionPolicy.RUNTIME)
public @interface CommandHandler {
    String[] commands();
}
