package com.example.aliceservice.skill.calendars;

import com.example.aliceservice.skill.calendars.model.Event;

import java.util.List;

public interface ICalendar {
    void authenticate();

    void addEvent();

    void updateEvent();

    void deleteEvent();

    Event getEvent();

    List<Event> getEventsByDay();

    List<Event> getEventsTemporarily();
}
