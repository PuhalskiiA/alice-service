package com.example.skill.util.handlers.utils;

import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.services.tokenService.TokenService;
import com.example.skill.util.handlers.CommandHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"мои календари"})
public class OwnSourcesHandler extends Handler {
    ExternalServicesRepository externalServicesRepository;
    TokenService tokenService;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
        List<String> userSources = tokenService.getSourcesByUserID(request.getUserPsuid());

        userSources.remove("YANDEX");

        if (userSources.isEmpty()) {
            response.setText("Нет активных календарей");
            return response;
        }

        response.setText("Твои календари: " + String.join(", ", userSources));

        return response;
    }
}
