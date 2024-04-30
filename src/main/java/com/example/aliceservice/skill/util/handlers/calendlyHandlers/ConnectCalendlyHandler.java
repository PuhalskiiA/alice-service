package com.example.aliceservice.skill.util.handlers.calendlyHandlers;

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

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommandHandler(commands = {"подключить calendly"})
public class ConnectCalendlyHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        yandexAliceResponse.getResponse().setText("Скажи \"проверь подключение к calandly\", чтобы понять, " +
                "что все прошло успешно");

        return yandexAliceResponse;
    }
}
