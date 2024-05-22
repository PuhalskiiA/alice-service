package com.example.aliceservice.skill.util.handlers.calendlyHandlers;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YAResponseSessionState;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.model.entityes.Token;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import com.example.aliceservice.skill.services.tokenService.TokenService;
import com.example.aliceservice.skill.util.Sources;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommandHandler(commands = {"запусти calendly"})
public class SelectCalendlyHandler extends Handler {

    @Autowired
    private TokenService tokenService;

    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<YAButton> buttons = new ArrayList<>();

        Optional<Token> token = tokenService.getTokenByPsuidAndSource(getUserPsuid(yandexAliceRequest),
                Sources.CALENDLY.toString());

        if (token.isEmpty()) {
            yandexAliceResponse.getResponse().setText("Что-то пошло не так. Возможно, ты не авторизовался в навыке " +
                    "или не подключил календарь.");

            buttons.add(new YAButton("Авторизироваться",
                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

            buttons.add(new YAButton("Подключить Calendly",
                    oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

            yandexAliceResponse.getResponse().setButtons(buttons);

            return yandexAliceResponse;
        }

        yandexAliceResponse.getResponse().setText("Хорошо. Чтобы выйти, скажи \"абрикос\".");
        yandexAliceResponse.setSessionState(new YAResponseSessionState(SessionState.CALENDLY));

//        try {
//            Optional<Token> token = tokenService.getTokenByPsuidAndSource(getUserPsuid(yandexAliceRequest),
//                    Sources.CALENDLY.toString());
//
//            if (token.isPresent()) {
//                yandexAliceResponse.getResponse().setText("Хорошо. Чтобы выйти, скажи \"абрикос\".");
//                yandexAliceResponse.setSessionState(new YAResponseSessionState(SessionState.CALENDLY));
//            }
//        } catch (UserNotFoundException e) {
//            yandexAliceResponse.getResponse().setText("Что-то пошло не так. Возможно, вы не авторизовались в навыке " +
//                    "или не подключили календарь");
//
//            buttons.add(new YAButton("Авторизироваться",
//                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//            buttons.add(new YAButton("Подключить Calendly",
//                    oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//            yandexAliceResponse.getResponse().setButtons(buttons);
//        }

        return yandexAliceResponse;
    }
}
