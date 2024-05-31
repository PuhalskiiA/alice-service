package com.example.skill.util.handlers.yadexID;

import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"авторизироваться"})
public class AuthorizeHandler extends Handler {
    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        response.setText("Попроси меня проверить авторизацию, чтобы мы были уверены, " +
                "что все прошло хорошо.");

        return response;
    }
}
