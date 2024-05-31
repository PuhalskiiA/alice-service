package com.example.skill.util.handlers.calendlyHandlers;

import com.example.skill.model.entityes.Token;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.services.OAuthService.YandexOAuthService;
import com.example.skill.services.tokenService.TokenService;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.calendars.Sources;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Optional<Token> token = tokenService.getTokenByPsuidAndSource(request.getUserPsuid(),
                Sources.CALENDLY.toString());

//        if (token.isEmpty()) {
//            response.setText("Что-то пошло не так. Возможно, ты не авторизовался в навыке " +
//                    "или не подключил календарь.");
//
//            buttons.add(new YAButton("Авторизироваться",
//                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//            buttons.add(new YAButton("Подключить Calendly",
//                    oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//            yandexAliceResponse.getResponse().setButtons(buttons);
//
//            return yandexAliceResponse;
//        }
//
//        yandexAliceResponse.getResponse().setText("Хорошо. Чтобы выйти, скажи \"абрикос\".");
//        yandexAliceResponse.setSessionState(new YAResponseSessionState(SessionState.CALENDLY));

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

        return response;
    }
}
