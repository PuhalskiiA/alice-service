package com.example.aliceservice.skill.util.handlers.functional;

import com.example.aliceservice.skill.calendars.Calendars;
import com.example.aliceservice.skill.calendars.EventInfo;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.util.handlers.SourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"добавь план"})
public class AddPlanHandler extends Handler {
    @Autowired
    private SourceStateRepository sourceStateRepository;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        Calendars calendar = sourceStateRepository.getSource(yandexAliceRequest.getSessionState().getUserState().getState());

        try {
            calendar.addPlan(new EventInfo());

            yandexAliceResponse.getResponse().setText("Хорошо, добавила");
        } catch (Exception e) {
            yandexAliceResponse.getResponse().setText("Что-то пошло не так, попробуй еще раз.");
        }

        return yandexAliceResponse;
    }
}
