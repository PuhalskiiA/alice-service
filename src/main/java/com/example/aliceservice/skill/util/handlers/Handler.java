package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.calendars.Plan;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAResponseSessionState;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;

public abstract class Handler {
    protected YandexAliceResponse getDefaultResponse(YandexAliceRequest yandexAliceRequest) {
        YASkillResponse skillResponse = new YASkillResponse();

        return new YandexAliceResponse(skillResponse,
                new YAResponseSessionState(yandexAliceRequest.getSessionState().getSessionState().getState()), "1.0");
    }

    protected String getUserPsuid(YandexAliceRequest yandexAliceRequest) {
        return yandexAliceRequest.getSession().getUser().getUserId();
    }

    protected Plan getPlanForAdding(YandexAliceRequest yandexAliceRequest) {
        Plan plan = new Plan();

        plan.setName(yandexAliceRequest.getRequest().getNlu().getEntities().get(0).getValue());
        plan.setDuration();
        plan.setDate_start();
        plan.setDate_end();

        return plan;
    }

    public abstract YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest);
}
