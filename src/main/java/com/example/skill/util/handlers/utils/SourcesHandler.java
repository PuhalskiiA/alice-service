package com.example.skill.util.handlers.utils;

import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.calendars.Sources;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommandHandler(commands = {"доступные календари"})
public class SourcesHandler extends Handler {
    @Autowired
    private OAuthService oAuthService;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
//
//        List<YAButton> buttons = new ArrayList<>();

        List<String> sourcesList = new ArrayList<>();

        for (Sources source : Sources.values()) {
            if (source != Sources.YANDEX) sourcesList.add(source.toString());
        }

        response.setText("Сейчас поддерживаются следующие календари: " +
                String.join(", ", sourcesList));

//        buttons.add(new YAButton("Подключить Calendly",
//                oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//        yandexAliceResponse.getResponse().setButtons(buttons);

        return response;
    }
}
