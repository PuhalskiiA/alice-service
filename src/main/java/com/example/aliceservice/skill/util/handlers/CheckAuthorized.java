package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommandHandler(commands = {"проверь авторизацию"})
public class CheckAuthorized extends Handler {
    @Autowired
    private UserService userService;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        Optional<User> user = userService.getUserByPsuid(getUserPsuid(yandexAliceRequest));

        if (user.isPresent()) {
            yandexAliceResponse.getResponse().setText(user.get().getName() + ", все прошло успешно!");
        } else {
            yandexAliceResponse.getResponse().setText("Что то пошло не так:(");
        }

        return yandexAliceResponse;
    }
}
