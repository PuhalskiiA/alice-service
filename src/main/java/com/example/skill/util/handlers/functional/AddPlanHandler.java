package com.example.skill.util.handlers.functional;

import com.example.skill.model.components.Plan;
import com.example.skill.util.externalCalendar.Calendar;
import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;
import com.example.skill.util.externalAssistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.externalCalendar.CalendarStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"добавь план"})
public class AddPlanHandler extends Handler {
    @Autowired
    private CalendarStateRepository calendarStateRepository;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

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
