package com.example.aliceservice.skill.util.handlers.utilsHandlers;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"ping"}, state = SessionState.PING)
public class PingHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        yandexAliceResponse.getResponse().setText("");

        return yandexAliceResponse;
    }
}
