package com.example.aliceservice.skill.util.handlers.introduction;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.response.YAResponseSessionState;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import com.example.aliceservice.skill.services.userService.UserService;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommandHandler(commands = {""}, state = SessionState.INITIAL)
public class HelloHandler extends Handler {
    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Autowired
    private UserService userService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        List<YAButton> buttons = new ArrayList<>();

        Optional<User> user = userService.getUserByPsuid(getUserPsuid(yandexAliceRequest));

        if (user.isPresent()) {
            yandexAliceResponse.getResponse().setText("Здравствуй, " + user.get().getName() + "! Рада снова тебя услышать!");
        } else {
            yandexAliceResponse.getResponse().setText("Привет! Я твой персональный помощник в планировании дня, скажи \"расскажи о себе\", " +
                    "чтобы немного узнать обо мне.");

            buttons.add(new YAButton("Авторизироваться",
                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
        }

        yandexAliceResponse.getResponse().setButtons(buttons);

        return yandexAliceResponse;
    }
}
