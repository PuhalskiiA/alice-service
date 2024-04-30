package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommandHandler(commands = {"подключить calendly"})
public class CalendlyHandler extends Handler {
    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<YAButton> buttons = new ArrayList<>();

        buttons.add(new YAButton("Подключить Calendly",
                oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

        yandexAliceResponse.getResponse().setButtons(buttons);
        yandexAliceResponse.getResponse().setText("Давай попробуем");

        return yandexAliceResponse;
    }
}
