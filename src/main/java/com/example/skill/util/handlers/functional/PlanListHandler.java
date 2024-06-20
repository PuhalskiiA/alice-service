package com.example.skill.util.handlers.functional;

import com.example.skill.model.components.Plan;
import com.example.skill.util.external_calendar.Calendar;
import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.external_calendar.CalendarStateRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"дай список дел на сегодня"})
public class PlanListHandler extends Handler {
    CalendarStateRepository calendarStateRepository;
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Calendar calendar = calendarStateRepository.getCalendar(request.getUserSessionState());

        response.setText("На сегодня у вас запланировано:\n"
                + calendar.getEvents(new Plan()));

        return response;
    }
}
