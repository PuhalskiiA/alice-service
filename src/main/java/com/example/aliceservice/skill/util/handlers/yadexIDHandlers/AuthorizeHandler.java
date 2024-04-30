package com.example.aliceservice.skill.util.handlers.yadexIDHandlers;

import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"авторизироваться"})
public class AuthorizeHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        yandexAliceResponse.getResponse().setText("Скажите \"проверь авторизацию\", чтобы понять, что все прошло успешно");

        return yandexAliceResponse;
    }
}
