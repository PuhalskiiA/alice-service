package com.example.aliceservice.skill.util.handlers.calendlyHandlers.auth;

import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"подключить calendly"})
public class ConnectCalendlyHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        yandexAliceResponse.getResponse().setText("Попроси меня проверить подключение к Calendly, " +
                "чтобы мы были уверены, что все прошло хорошо");

        return yandexAliceResponse;
    }
}
