package com.example.skill.util.handlers.functional;

import com.example.skill.calendars.Calendars;
import com.example.skill.calendars.EventInfo;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.SourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"дай список дел на сегодня"})
public class PlanListHandler extends Handler {
    @Autowired
    private SourceStateRepository sourceStateRepository;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Calendars calendar = sourceStateRepository.getSource(request.getUserSessionState());

        response.setText("На сегодня у вас запланировано:\n"
                + calendar.getEvents(new EventInfo()));

        return response;
    }
}
