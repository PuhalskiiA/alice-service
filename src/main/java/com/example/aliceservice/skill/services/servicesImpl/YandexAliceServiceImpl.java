package com.example.aliceservice.skill.services.servicesImpl;

import com.example.aliceservice.skill.services.YandexAliceService;
import com.example.aliceservice.skill.model.alice.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YandexAliceServiceImpl implements YandexAliceService {
    @Override
    public YandexAliceResponse talkYandexAlice(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = yandexResponse();

        yandexAliceResponse.getResponse().setText("Привет! Я твой помощник в планировании дня. " +
                "Скажи \"расскажи о себе\", чтобы немного узнать обо мне.\"");

        YASession yandexSession = yandexAliceRequest.getSession();

//        YASkillRequest skillRequest = yandexAliceRequest.getRequest();

        List<YAButton> listOfButtons = new ArrayList<>();

        listOfButtons.add(new YAButton("Давай авторизируемся",
                new OAuthServiceImpl().getUrl(), true));
        listOfButtons.add(new YAButton("Расскажи о себе",
                "https://yandex.ru/dev/dialogs/alice/doc/buttons.html", true));

//        yandexAliceResponse.getResponse().setText("Здравствуй, Александр!");
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
