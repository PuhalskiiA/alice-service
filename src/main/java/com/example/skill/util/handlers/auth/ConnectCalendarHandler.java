package com.example.skill.util.handlers.auth;

import com.example.skill.model.entityes.User;
import com.example.skill.services.userService.UserService;
import com.example.skill.util.Sources;
import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;
import com.example.skill.util.externalAssistant.ExternalServicesRepository;
import com.example.skill.util.externalCalendar.SourceFactory;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommandHandler(commands = {"подключить calendly"})
public class ConnectCalendarHandler extends Handler {
    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Autowired
    private UserService userService;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Optional<User> user = userService.checkSourceForUser(request.getUserPsuid(),
                SourceFactory.getSource(request.getUserCommand()).toString());

        if (user.isPresent()) {
            response.setText(user.get().getName() + ", у тебя уже подключен этот календарь!");
        } else {
            response.setText("Звучит интригующе, давай!");
        }

        return response;
    }
}
