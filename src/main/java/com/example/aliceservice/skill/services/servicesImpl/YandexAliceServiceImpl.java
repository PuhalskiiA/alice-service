package com.example.aliceservice.skill.services.servicesImpl;

import com.example.aliceservice.skill.services.YandexAliceService;
import com.example.aliceservice.skill.model.alice.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class YandexAliceServiceImpl implements YandexAliceService {
    @Override
    public YandexAliceResponse talkYandexAlice(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = yandexResponse();

        yandexAliceResponse.getResponse().setText("Привет! Я твой помощник в планировании дня. " +
                "Скажи \"расскажи, что ты можешь\", чтобы немного узнать обо мне.\"");

        YASession yandexSession = yandexAliceRequest.getSession();
        log.info("session {} userId {} applicationId {} utterance {}", yandexSession.getSessionId(),
                yandexSession.getUser() != null?yandexSession.getUser().getUserId():null,
                yandexSession.getApplication() != null?yandexSession.getApplication().getApplicationId():null,
                yandexAliceRequest.getRequest() != null?yandexAliceRequest.getRequest().getCommand():null);

//        YASkillRequest skillRequest = yandexAliceRequest.getRequest();

//        if (yandexAliceRequest.getRequest() != null && yandexAliceRequest.getRequest().getMarkup() != null) {
//            List<YAButton> listOfButtons = new ArrayList<>();
//
//            listOfButtons.add(new YAButton("Привет", "", false));
//
//            yandexAliceResponse.getResponse().setText("Привет, как ты?");
//            yandexAliceResponse.getResponse().setButtons(listOfButtons);
//            yandexAliceResponse.getResponse().setEndSession(false);
//        }

        List<YAButton> listOfButtons = new ArrayList<>();

        listOfButtons.add(new YAButton("Привет", "https://www.youtube.com/watch?v=jW3opObm8I8", true));

        yandexAliceResponse.getResponse().setText("Привет, как ты?");
        yandexAliceResponse.getResponse().setButtons(listOfButtons);
        yandexAliceResponse.getResponse().setEndSession(false);

        return yandexAliceResponse;
    }

    private YandexAliceResponse yandexResponse() {
        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse();
        yandexAliceResponse.setResponse(new YASkillResponse());
        return yandexAliceResponse;
    }


}
