package com.example.calendars.calendly;

import com.example.skill.model.components.Plan;
import com.example.skill.services.tokenService.TokenService;
import com.example.skill.util.SessionState;
import com.example.skill.util.external_calendar.Calendar;
import com.example.skill.util.Sources;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Calendly extends Calendar {
    TokenService tokenServiceImpl;
    RestTemplate restTemplate;
    Sources source = Sources.CALENDLY;
    SessionState sessionState = SessionState.CALENDLY;

    @Override
    public void addPlan(Plan event) {

    }

    @Override
    public String getEvents(Plan event) {
        return null;
    }

    @Override
    public Sources getSource() {
        return source;
    }

    @Override
    public SessionState getSessionState() {
        return sessionState;
    }
}
