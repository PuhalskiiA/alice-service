package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.tokenService.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommandHandler(commands = {"asd", "asd"})
public class SourcesHandler extends Handler {
    @Autowired
    private TokenService tokenService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        List<String> userSources = tokenService.getSourcesByUserID(getUserPsuid(yandexAliceRequest));

        YASkillResponse skillResponse = new YASkillResponse();

//        if (userSources == null) {
//            skillResponse.setText("Нет доступных календарей");
//            return new YandexAliceResponse(skillResponse, SessionState.INITIAL, "1.0");
//        }
//
//        userSources.remove("YANDEX");
//
//        skillResponse.setText("Доступны следующие календари: " + String.join(", ", userSources));

        return new YandexAliceResponse(skillResponse, SessionState.INITIAL, "1.0");
    }
}
