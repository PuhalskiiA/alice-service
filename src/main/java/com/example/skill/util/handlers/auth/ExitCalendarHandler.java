package com.example.skill.util.handlers.auth;

import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"абрикос"})
public class ExitCalendarHandler extends Handler {
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        response.setText("Поняла, выхожу");
        response.setState(null);

        return response;
    }
}
