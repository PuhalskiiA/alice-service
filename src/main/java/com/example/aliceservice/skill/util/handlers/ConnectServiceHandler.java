package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"подключи calandly"})
public class ConnectServiceHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {


        return null;
    }
}