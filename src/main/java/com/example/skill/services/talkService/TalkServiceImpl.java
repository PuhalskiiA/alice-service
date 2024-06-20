package com.example.skill.services.talkService;

import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandlersRepository;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TalkServiceImpl implements TalkService {
    CommandHandlersRepository commandHandlersRepository;
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse talk(CustomRequest request) {
        Handler handler = commandHandlersRepository.getHandler(request.getUserCommand());

        //Command not found
        if (handler == null) {
            CustomResponse response = externalServicesRepository.getCustomResponse(request);
            response.setText("Не поняла, попробуй другими словами");
            return response;
        }

        return handler.getResponse(request);
    }
}
