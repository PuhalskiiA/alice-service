package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommandHandler(commands = {""})
public class HelloHandler extends Handler {
    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        List<YAButton> buttons = new ArrayList<>();

        yandexAliceResponse.getResponse().setText("Привет! Я твой персональный помощник в планировании дня, скажи \"расскажи о себе\", " +
                "чтобы немного узнать обо мне.");

        buttons.add(new YAButton("Авторизироваться",
                yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

        yandexAliceResponse.getResponse().setButtons(buttons);

        return yandexAliceResponse;
    }
}
