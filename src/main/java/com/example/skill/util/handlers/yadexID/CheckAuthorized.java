package com.example.skill.util.handlers.yadexID;

import com.example.alice.model.response.YAButton;
import com.example.skill.model.entityes.User;
import com.example.skill.services.OAuthService.YandexOAuthService;
import com.example.skill.services.userService.UserService;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommandHandler(commands = {"проверить авторизацию"})
public class CheckAuthorized extends Handler {
    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Autowired
    private UserService userService;

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
