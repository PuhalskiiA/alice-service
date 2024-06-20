package com.example.skill.util.external_utils.external_calendar;

import com.example.skill.model.components.Plan;
import com.example.skill.util.external_utils.SessionState;
import com.example.skill.util.external_utils.Sources;

public abstract class Calendar {
    public abstract void addPlan(Plan event);
    public abstract String getEvents(Plan event);
    public abstract Sources getSource();
    public abstract SessionState getSessionState();
}
