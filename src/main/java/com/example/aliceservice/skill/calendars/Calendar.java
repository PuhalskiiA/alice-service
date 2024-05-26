package com.example.aliceservice.skill.calendars;

public interface Calendar {
    void addPlan(Plan event);

    String getEvents(Plan event);


}
