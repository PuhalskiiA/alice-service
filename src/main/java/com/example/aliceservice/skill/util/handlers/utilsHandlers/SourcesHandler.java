package com.example.aliceservice.skill.util.handlers.utilsHandlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import com.example.aliceservice.skill.util.Sources;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommandHandler(commands = {"доступные календари"})
public class SourcesHandler extends Handler {
    @Autowired
    private OAuthService oAuthService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<YAButton> buttons = new ArrayList<>();

        List<String> sourcesList = new ArrayList<>();

        for (Sources source : Sources.values()) {
            if (source != Sources.YANDEX) sourcesList.add(source.toString());
        }

        yandexAliceResponse.getResponse().setText("Сейчас поддерживаются следующие календари: " +
                String.join(", ", sourcesList));

        buttons.add(new YAButton("Подключить Calendly",
                oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

        yandexAliceResponse.getResponse().setButtons(buttons);

        return yandexAliceResponse;
    }
}
