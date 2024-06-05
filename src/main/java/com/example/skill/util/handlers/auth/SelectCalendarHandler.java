package com.example.skill.util.handlers.auth;

import com.example.skill.model.components.Button;
import com.example.skill.model.components.URLButton;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.util.SessionState;
import com.example.skill.util.Sources;
import com.example.skill.util.externalAssistant.ExternalService;
import com.example.skill.util.externalCalendar.Calendar;
import com.example.skill.model.entityes.Token;
import com.example.skill.services.tokenService.TokenService;
import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;
import com.example.skill.util.externalAssistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.externalCalendar.CalendarStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommandHandler(commands = {"запусти calendly"})
public class SelectCalendarHandler extends Handler {
    @Autowired
    @Qualifier("yandexOAuthServiceImpl")
    private OAuthService yandexOAuthServiceImpl;

    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService calendlyOAuthServiceImpl;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Autowired
    private CalendarStateRepository calendarStateRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
        ExternalService externalService = externalServicesRepository.getService(request);

        List<Button> buttons = new ArrayList<>();

        URLButton authButton = externalService.getURLButton();
        URLButton calendlyButton = externalService.getURLButton();

        SessionState sessionState = request.getUserSessionState();

        if (!(sessionState == null || sessionState.toString().isEmpty())) {
            Calendar calendar = calendarStateRepository.getCalendar(request.getUserSessionState());
            response.setText("Ты уже используешь календарь: " + calendar.getSource()
                    + ". Скажи \"абрикос\", чтобы выйти");
            return response;
        }

        Optional<Token> token = tokenService.getTokenByPsuidAndSource(request.getUserPsuid(),
                getSource(request.getUserCommand()).toString());

        if (token.isEmpty()) {
            response.setText("Что-то пошло не так. Возможно, ты не авторизовался в навыке " +
                    "или не подключил календарь.");

            authButton.setButton("Авторизироваться", yandexOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);
            buttons.add(authButton);
            calendlyButton.setButton("Подключить Calendly", calendlyOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);
            buttons.add(calendlyButton);

            response.setButtons(buttons);

            return response;
        }

        response.setText("Хорошо. Чтобы выйти, скажи \"абрикос\".");
        response.setState(SessionState.CALENDLY);

        return response;
    }

    private Sources getSource(String command) {
        if (command.contains("calendly")) return Sources.CALENDLY;
        return null;
    }
}
