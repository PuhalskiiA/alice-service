package com.example.aliceservice.skill.util.handlers.yadexIDHandlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YAButton;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import com.example.aliceservice.skill.services.userService.UserService;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommandHandler(commands = {"проверить авторизацию"})
public class CheckAuthorized extends Handler {
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
            yandexAliceResponse.getResponse().setText(user.get().getName() + ", все прошло успешно!");
        } else {
            yandexAliceResponse.getResponse().setText("Что то пошло не так:( Попробуй снова.");

            buttons.add(new YAButton("Авторизироваться",
                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));

            yandexAliceResponse.getResponse().setButtons(buttons);
        }

        return yandexAliceResponse;
    }
}
