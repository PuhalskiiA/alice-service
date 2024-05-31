package com.example.skill.util.handlers;

import com.example.skill.calendars.Calendars;
import com.example.skill.calendars.calendly.Calendly;
import com.example.alice.util.SessionState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SourceStateRepository {
    Map<SessionState, Calendars> hashMap = Map.ofEntries(
            Map.entry(SessionState.CALENDLY, new Calendly())
    );

    public Calendars getSource(SessionState state) {
        return hashMap.get(state);
    }
}
