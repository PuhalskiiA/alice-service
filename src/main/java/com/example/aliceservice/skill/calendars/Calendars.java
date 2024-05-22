package com.example.aliceservice.skill.calendars;

public interface Calendars {
    void addPlan(EventInfo event);

    String getEvents(EventInfo event);
}
