package com.example.skill.util.handlers.functional;

import com.example.skill.calendars.Calendars;
import com.example.skill.calendars.EventInfo;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.SourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"добавь план"})
public class AddPlanHandler extends Handler {
    @Autowired
    private SourceStateRepository sourceStateRepository;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Calendars calendar = sourceStateRepository.getSource(request.getUserSessionState());

        try {
            calendar.addPlan(new EventInfo());
            response.setText("Хорошо, добавила");
        } catch (Exception e) {
            response.setText("Что-то пошло не так, попробуй еще раз.");
        }

        return response;
    }
}
