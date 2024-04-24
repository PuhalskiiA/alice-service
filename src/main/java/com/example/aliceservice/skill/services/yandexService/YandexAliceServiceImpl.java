package com.example.aliceservice.skill.services.yandexService;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YARequestType;
import com.example.aliceservice.skill.model.alice.request.YASession;
import com.example.aliceservice.skill.model.alice.request.YASkillRequest;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.*;
import com.example.aliceservice.skill.services.OAuthService.impl.CalendlyOAuthServiceImpl;
import com.example.aliceservice.skill.services.OAuthService.impl.YandexOAuthServiceImpl;
import com.example.aliceservice.skill.services.talk.TalkServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YandexAliceServiceImpl implements YandexAliceService {
    @Autowired
    private TalkServiceImpl talkService;

    @Override
    public YandexAliceResponse talkYandexAlice(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = yandexResponse();

        YASession yandexSession = yandexAliceRequest.getSession();
        YASkillRequest skillRequest = yandexAliceRequest.getRequest();
        List<YAButton> listOfButtons = new ArrayList<>();
        SessionState aliceUserState = yandexAliceRequest.getSessionState().getUserState().getState();
        String applicationID = yandexAliceRequest.getSession().getApplication().getApplicationId();
        String userID = yandexAliceRequest.getSession().getUser().getUserId();

        if (aliceUserState == null && skillRequest.getCommand().isEmpty()) {

            yandexAliceResponse.getResponse().setText("Привет! Я твой персональный помощник в планировании дня, " +
                    "скажи \"расскажи о себе\", чтобы немного узнать обо мне.");

        } else if (skillRequest != null && skillRequest.getMarkup() != null &&
                skillRequest.getMarkup().isDangerousContent()) {

            yandexAliceResponse.getResponse().setText("Не поняла, попробуй сказать другими словами.");

        } else if (skillRequest != null && skillRequest.getCommand().equals("расскажи о себе")) {

            yandexAliceResponse.getResponse().setText(talkService.saidSelfInformation());

        } else if (skillRequest.getCommand().equals("давай авторизируемся")) {

            //Check auth of user in database -> (true) "U're already authorized" : (false) "Let's authorize"
            yandexAliceResponse.getResponse().setText("Для авторизации нужен ЯндексID и чат со мной. " +
                    "Если ты уже в нем, просто нажми клавишу \"Давай авторизируемся\"");

        } else if (skillRequest.getCommand().equals("спасибо")) {

            yandexAliceResponse.getResponse().setText("Стараемся, Клим Саныч, стараемся");

        } else {

            yandexAliceResponse.getResponse().setText("Не поняла");

        }

        listOfButtons.add(new YAButton("Давай авторизируемся",
                new YandexOAuthServiceImpl().getCodeURL(applicationID, userID), true));
        listOfButtons.add(new YAButton("Подключить Calendly",
                new CalendlyOAuthServiceImpl().getCodeURL(), true));

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

//    private SessionState checkSessionState(YandexAliceRequest yandexAliceRequest) {
//        return yandexAliceRequest.getSessionState();
//    }

}
