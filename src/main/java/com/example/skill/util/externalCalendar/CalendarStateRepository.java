package com.example.skill.util.externalCalendar;

import com.example.calendars.calendly.Calendly;
import com.example.skill.util.SessionState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CalendarStateRepository {
    Map<SessionState, Calendar> hashMap = Map.ofEntries(
            Map.entry(SessionState.CALENDLY, new Calendly())
    );

    public Calendar getCalendar(SessionState state) {
        return hashMap.get(state);
    }
}
