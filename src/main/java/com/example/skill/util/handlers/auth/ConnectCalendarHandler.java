package com.example.skill.util.handlers.auth;

import com.example.skill.model.entityes.User;
import com.example.skill.services.userService.UserService;
import com.example.skill.util.external_utils.external_assistant.CustomRequest;
import com.example.skill.util.external_utils.external_assistant.CustomResponse;
import com.example.skill.util.external_utils.external_assistant.ExternalServicesRepository;
import com.example.skill.util.external_utils.external_calendar.SourceFactory;
import com.example.skill.util.handlers.Handler;
import com.example.skill.util.handlers.CommandHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommandHandler(commands = {"подключить calendly"})
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ConnectCalendarHandler extends Handler {
    ExternalServicesRepository externalServicesRepository;
    UserService userService;

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
