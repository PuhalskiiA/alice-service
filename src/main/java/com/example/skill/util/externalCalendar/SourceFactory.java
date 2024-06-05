package com.example.skill.util.externalCalendar;

import com.example.calendars.calendly.Calendly;
import com.example.skill.util.Sources;

public class SourceFactory {
    public static Sources getSource(String command) {
        if (command.contains("calendly")) return Sources.CALENDLY;

        return null;
    }
}
