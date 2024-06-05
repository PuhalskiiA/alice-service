package com.example.skill.services.talkService;

import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;
import com.example.skill.util.externalAssistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandlersRepository;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkServiceImpl implements TalkService {
    @Autowired
    private CommandHandlersRepository commandHandlersRepository;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

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
