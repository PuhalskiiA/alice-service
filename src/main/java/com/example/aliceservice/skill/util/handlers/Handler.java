package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;

public abstract class Handler {
    protected YandexAliceResponse getDefaultResponse(YandexAliceRequest yandexAliceRequest) {
        YASkillResponse skillResponse = new YASkillResponse();

        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse(skillResponse,
                yandexAliceRequest.getSessionState().getSessionState().getState(), "1.0");

        return yandexAliceResponse;
    }

    protected String getUserPsuid(YandexAliceRequest yandexAliceRequest) {
        return yandexAliceRequest.getSession().getUser().getUserId();
    }

    public abstract YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest);
}
