package com.example.aliceservice.skill.util.handlers.calendlyHandlers.auth;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import com.example.aliceservice.skill.services.userService.UserService;
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
@CommandHandler(commands = {"проверь подключение к calandly"})
public class CheckCalandlyHandler extends Handler {
    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Autowired
    private UserService userService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
        List<YAButton> buttons = new ArrayList<>();

        Optional<User> user = userService.checkSourceForUser(getUserPsuid(yandexAliceRequest), Sources.CALENDLY.toString());

        if (user.isPresent()) {
            yandexAliceResponse.getResponse().setText(user.get().getName() + ", все получилось!");
        } else {
            buttons.add(new YAButton("Подключить Calendly",
                    oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

            yandexAliceResponse.getResponse().setText("Что то пошло не так:( Попробуй снова.");
            yandexAliceResponse.getResponse().setButtons(buttons);
        }

        return yandexAliceResponse;
    }
}
