package com.example.aliceservice.skill.util.handlers.calendlyHandlers;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.response.YAResponseSessionState;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"подключить calendly"}, state = SessionState.INITIAL)
public class ConnectCalendlyHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        yandexAliceResponse.getResponse().setText("Скажи \"проверь подключение к calandly\", чтобы понять, " +
                "что все прошло успешно");
        yandexAliceResponse.setSessionState(new YAResponseSessionState(SessionState.CALENDLY));

        return yandexAliceResponse;
    }
}
