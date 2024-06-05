package com.example.skill.util.externalCalendar;

import com.example.skill.model.components.Plan;
import com.example.skill.util.Sources;

public interface Calendar {
    void addPlan(Plan event);

    String getEvents(Plan event);

    Sources getSource();
}
