package com.example.skill.util.handlers.functional;

import com.example.skill.model.components.Plan;
import com.example.skill.util.external_utils.external_calendar.Calendar;
import com.example.skill.util.external_utils.external_assistant.CustomRequest;
import com.example.skill.util.external_utils.external_assistant.CustomResponse;
import com.example.skill.util.external_utils.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.external_utils.external_calendar.CalendarStateRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"добавь план"})
public class AddPlanHandler extends Handler {
    CalendarStateRepository calendarStateRepository;
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Calendar calendar = calendarStateRepository.getCalendar(request.getUserSessionState());

        try {
            calendar.addPlan(new Plan());
            response.setText("Хорошо, добавила");
        } catch (Exception e) {
            response.setText("Что-то пошло не так, попробуй еще раз.");
        }

        return response;
    }
}
