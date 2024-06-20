package com.example.skill.util.handlers.utils;

import com.example.skill.model.components.Button;
import com.example.skill.model.components.URLButton;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.util.Sources;
import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalService;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"доступные календари"})
public class SourcesHandler extends Handler {
    OAuthService calendlyOAuthServiceImpl;
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
        ExternalService externalService = externalServicesRepository.getService(request);

        List<Button> buttons = new ArrayList<>();
        URLButton calendlyButton = externalService.getURLButton();

        List<String> sourcesList = new ArrayList<>();

        for (Sources source : Sources.values()) {
            if (source != Sources.YANDEX) sourcesList.add(source.toString());
        }

        response.setText("Сейчас поддерживаются следующие календари: " +
                String.join(", ", sourcesList));

        calendlyButton.setButton("Подключить Calendly",
                calendlyOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);

        response.setButtons(buttons);

        return response;
    }
}
