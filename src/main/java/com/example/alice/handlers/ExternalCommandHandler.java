package com.example.alice.handlers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value= RetentionPolicy.RUNTIME)
public @interface ExternalCommandHandler {
    String[] commands();
}
