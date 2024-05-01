package com.example.aliceservice.skill.util.handlers.introduction;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommandHandler(commands = {""}, state = SessionState.INITIAL)
public class HelloHandler extends Handler {
    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        List<YAButton> buttons = new ArrayList<>();

        buttons.add(new YAButton("Авторизироваться",
                yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

        yandexAliceResponse.getResponse().setText("Привет! Я твой персональный помощник в планировании дня, скажи \"расскажи о себе\", " +
                "чтобы немного узнать обо мне.");
        yandexAliceResponse.getResponse().setButtons(buttons);
        yandexAliceResponse.setSessionState(SessionState.INITIAL);

        return yandexAliceResponse;
    }
}
