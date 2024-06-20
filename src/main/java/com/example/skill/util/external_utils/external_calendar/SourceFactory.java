package com.example.skill.util.external_utils.external_calendar;

import com.example.skill.util.external_utils.Sources;

public class SourceFactory {
    public static Sources getSource(String command) {
        if (command.contains("calendly")) return Sources.CALENDLY;

        return null;
    }
}
