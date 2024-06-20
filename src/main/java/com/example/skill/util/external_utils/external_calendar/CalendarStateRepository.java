package com.example.skill.util.external_utils.external_calendar;

import com.example.skill.util.external_utils.SessionState;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;

@Component
public class CalendarStateRepository {
    EnumMap<SessionState, Calendar> calendarsStatesMap = new EnumMap<>(SessionState.class);
    public CalendarStateRepository(List<Calendar> calendars) {
        for (Calendar calendar : calendars) {
            calendarsStatesMap.put(calendar.getSessionState(), calendar);
        }
    }

    public Calendar getCalendar(SessionState state) {
        return calendarsStatesMap.get(state);
    }
}
