package com.example.aliceservice.skill.util.handlers.utilsHandlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
@CommandHandler(commands = {"спасибо", "умница", "благодарю", "хорошая работа", "thanks"})
public class GoodResponseHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        Map<Integer, String> gladMap = Map.ofEntries(
                Map.entry(0, "Не за что"),
                Map.entry(1, "Рада стараться"),
                Map.entry(2, "Хвалите меня чаще"),
                Map.entry(3, "Мы с тобой - лучшая команда!")
                );

        String textResponse = gladMap.get(new Random().nextInt(gladMap.size()));

        yandexAliceResponse.getResponse().setText(textResponse);

        return yandexAliceResponse;
    }
}
