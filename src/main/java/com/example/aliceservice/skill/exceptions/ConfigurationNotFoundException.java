package com.example.aliceservice.skill.exceptions;

import org.yaml.snakeyaml.constructor.SafeConstructor;

public class ConfigurationNotFoundException extends RuntimeException {
    public ConfigurationNotFoundException(String msg) {
        super(msg);
    }
}
