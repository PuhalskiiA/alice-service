package com.example.skill.util.external_calendar;

import com.example.skill.model.components.Plan;
import com.example.skill.util.SessionState;
import com.example.skill.util.Sources;

public abstract class Calendar {
    public abstract void addPlan(Plan event);
    public abstract String getEvents(Plan event);
    public abstract Sources getSource();
    public abstract SessionState getSessionState();
}
