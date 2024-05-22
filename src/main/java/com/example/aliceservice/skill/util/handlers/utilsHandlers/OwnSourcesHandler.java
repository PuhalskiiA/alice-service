package com.example.aliceservice.skill.util.handlers.utilsHandlers;

import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.tokenService.TokenService;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommandHandler(commands = {"мои календари"})
public class OwnSourcesHandler extends Handler {
    @Autowired
    private TokenService tokenService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<String> userSources = tokenService.getSourcesByUserID(getUserPsuid(yandexAliceRequest));

        userSources.remove("YANDEX");

        if (userSources.isEmpty()) {
            yandexAliceResponse.getResponse().setText("Нет активных календарей");
            
            return yandexAliceResponse;
        }

        yandexAliceResponse.getResponse().setText("Твои календари: "
                + String.join(", ", userSources));

        return yandexAliceResponse;
    }
}
