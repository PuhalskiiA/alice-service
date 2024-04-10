package com.example.aliceservice.skill.services.servicesImpl;

import com.example.aliceservice.skill.model.alice.request.YASession;
import com.example.aliceservice.skill.model.alice.request.YASkillRequest;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.YandexAliceService;
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

        YASkillRequest skillRequest = yandexAliceRequest.getRequest();

        List<YAButton> listOfButtons = new ArrayList<>();

        listOfButtons.add(new YAButton("Давай авторизируемся",
                new OAuthServiceImpl().getUrl(), true));
        listOfButtons.add(new YAButton("Расскажи о себе",
                "https://yandex.ru/dev/dialogs/alice/doc/buttons.html", true));

        if (yandexAliceRequest.getRequest() != null && yandexAliceRequest.getRequest().getMarkup() != null
                && yandexAliceRequest.getRequest().getMarkup().isDangerousContent()) {
            yandexAliceResponse.getResponse().setText("Не поняла вас. Попробуйте сказать это другими словами.");
        } else if (yandexSession.){

        }

        return yandexAliceResponse;
    }

    private YandexAliceResponse yandexResponse() {
        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse();
        yandexAliceResponse.setResponse(new YASkillResponse());
        return yandexAliceResponse;
    }

}
