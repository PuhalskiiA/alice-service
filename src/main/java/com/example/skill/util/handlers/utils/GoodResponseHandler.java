package com.example.skill.util.handlers.utils;

import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
@CommandHandler(commands = {"спасибо", "умница", "благодарю", "хорошая работа", "thanks"})
public class GoodResponseHandler extends Handler {
    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Map<Integer, String> gladMap = Map.ofEntries(
                Map.entry(0, "Не за что"),
                Map.entry(1, "Рада стараться"),
                Map.entry(2, "Хвалите меня чаще"),
                Map.entry(3, "Мы с тобой - лучшая команда!")
                );

        response.setText(gladMap.get(new Random().nextInt(gladMap.size())));

        return response;
    }
}
