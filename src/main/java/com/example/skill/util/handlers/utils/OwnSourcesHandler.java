package com.example.skill.util.handlers.utils;

import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.services.tokenService.TokenService;
import com.example.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommandHandler(commands = {"мои календари"})
public class OwnSourcesHandler extends Handler {
    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Autowired
    private TokenService tokenService;

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
