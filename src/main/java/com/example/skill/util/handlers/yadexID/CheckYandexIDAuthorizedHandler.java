package com.example.skill.util.handlers.yadexID;

import com.example.skill.model.entityes.User;
import com.example.skill.services.userService.UserService;
import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"проверить авторизацию"})
public class CheckYandexIDAuthorizedHandler extends Handler {
    ExternalServicesRepository externalServicesRepository;
    UserService userService;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

//        List<YAButton> buttons = new ArrayList<>();

        Optional<User> user = userService.getUserByPsuid(request.getUserPsuid());

        if (user.isPresent()) {
            response.setText(user.get().getName() + ", все прошло успешно!");
        } else {
            response.setText("Что то пошло не так:( Попробуй снова.");

//            buttons.add(new YAButton("Авторизироваться",
//                    yandexOAuthService.getCodeURL(request.getPsuid()), true));
//
//            yandexAliceResponse.getResponse().setButtons(buttons);
        }

        return response;
    }
}
