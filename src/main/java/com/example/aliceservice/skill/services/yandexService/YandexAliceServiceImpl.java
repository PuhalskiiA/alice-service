package com.example.aliceservice.skill.services.yandexService;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YASession;
import com.example.aliceservice.skill.model.alice.request.YASkillRequest;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.OAuthServiceImpl;
import org.apache.logging.log4j.util.Strings;
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

//        yandexAliceRequest.setSessionState(new YARequestSessionState(SessionState.INITIAL));

//        if (yandexAliceRequest.getRequest() != null && yandexAliceRequest.getRequest().getMarkup() != null
//                && yandexAliceRequest.getRequest().getMarkup().isDangerousContent()) {
//            yandexAliceResponse.getResponse().setText("Не поняла тебя. Давай попробуем сказать по другому.");
//        } else if (yandexAliceRequest.getRequest() != null &&
//                checkSessionState(yandexAliceRequest) == null){
//            yandexAliceResponse.getResponse().setText("Привет?");
//            yandexAliceResponse.setSessionState(SessionState.INITIAL);
//        }

        yandexAliceResponse.getResponse().setButtons(listOfButtons);
        System.out.println(yandexAliceResponse);
        return yandexAliceResponse;
    }

    private YandexAliceResponse yandexResponse() {
        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse();
        yandexAliceResponse.setResponse(new YASkillResponse());
        return yandexAliceResponse;
    }

    private boolean commandDefined(YASkillRequest skillRequest) {
        return skillRequest != null && Strings.isNotBlank(skillRequest.getCommand());
    }

    private SessionState checkSessionState(YandexAliceRequest yandexAliceRequest) {
        return yandexAliceRequest.getSessionState().getSessionState();
    }

}
