package com.example.skill.util.handlers.calendlyHandlers.auth;

import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"подключить calendly"})
public class ConnectCalendlyHandler extends Handler {
    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        response.setText("Попроси меня проверить подключение к Calendly, " +
                "чтобы мы были уверены, что все прошло хорошо");

        return response;
    }
}