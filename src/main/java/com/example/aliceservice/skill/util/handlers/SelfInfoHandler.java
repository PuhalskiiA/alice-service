package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommandHandler(commands = {"расскажи о себе"})
public class SelfInfoHandler extends Handler {
    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<YAButton> buttons = new ArrayList<>();

        yandexAliceResponse.getResponse().setText("Я твой персональный помощник в планировании дня. " +
                "Через меня ты можешь авторизироваться в некоторые календари и совершать операции над своими задачами. " +
                "Пока что поддерживается только сервис Calendly, но я работаю над собой! Чтобы персонализировать общение, " +
                "а также добавить календари, нужно авторизироваться через чат со мной.");

        buttons.add(new YAButton("Авторизироваться",
                yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
        buttons.add(new YAButton("Подключить Calendly",
                oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

        yandexAliceResponse.getResponse().setButtons(buttons);

        return yandexAliceResponse;
    }
}
