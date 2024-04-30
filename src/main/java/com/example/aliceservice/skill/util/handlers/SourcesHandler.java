package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.tokenService.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommandHandler(commands = {"доступные календари"})
public class SourcesHandler extends Handler {
    @Autowired
    private TokenService tokenService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<String> userSources = tokenService.getSourcesByUserID(getUserPsuid(yandexAliceRequest));

        if (userSources == null) {

            yandexAliceResponse.getResponse().setText("Нет доступных календарей");
            yandexAliceResponse.setSessionState(SessionState.INITIAL);
            
            return yandexAliceResponse;
        }

        userSources.remove("YANDEX");

        yandexAliceResponse.getResponse().setText("Доступны следующие календари: " + String.join(", ", userSources));

        return yandexAliceResponse;
    }
}
