package com.example.skill.util.handlers.utils;

import com.example.skill.util.external_utils.external_assistant.CustomRequest;
import com.example.skill.util.external_utils.external_assistant.CustomResponse;
import com.example.skill.util.external_utils.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.CommandHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"ping"})
public class PingHandler extends Handler {
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        response.setText("");

        return response;
    }
}
