package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.calendars.Calendar;
import com.example.aliceservice.skill.calendars.calendly.Calendly;
import com.example.aliceservice.skill.model.alice.SessionState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SourceStateRepository {
    Map<SessionState, Calendar> hashMap = Map.ofEntries(
            Map.entry(SessionState.CALENDLY, new Calendly())
    );

    public Calendar getSource(SessionState state) {
        return hashMap.get(state);
    }
}
