package com.example.aliceservice.skill.util.handlers.functional;

import com.example.aliceservice.skill.calendars.Calendar;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.SourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"дай список дел на сегодня"})
public class PlanListHandler extends Handler {
    @Autowired
    private SourceStateRepository sourceStateRepository;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        Calendar calendar = sourceStateRepository.getSource(yandexAliceRequest.getSessionState().getUserState().getState());

        yandexAliceResponse.getResponse().setText("На сегодня у вас запланировано:\n"
                + calendar.getEvents(getPlanForAdding(yandexAliceRequest)));

        return yandexAliceResponse;
    }
}
