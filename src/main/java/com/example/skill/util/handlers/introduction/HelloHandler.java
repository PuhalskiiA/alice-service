package com.example.skill.util.handlers.introduction;

import com.example.skill.model.components.Button;
import com.example.skill.model.components.URLButton;
import com.example.skill.model.entityes.User;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.services.userService.UserService;
import com.example.skill.util.external_utils.external_assistant.CustomRequest;
import com.example.skill.util.external_utils.external_assistant.CustomResponse;
import com.example.skill.util.external_utils.external_assistant.ExternalService;
import com.example.skill.util.external_utils.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"", "на главную", "главная", "привет"})
public class HelloHandler extends Handler {
    OAuthService calendlyOAuthServiceImpl;
    OAuthService yandexOAuthServiceImpl;
    UserService userService;
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
        ExternalService externalService = externalServicesRepository.getService(request);

        List<Button> buttons = new ArrayList<>();

        URLButton authButton = externalService.getURLButton();
        URLButton calendlyButton = externalService.getURLButton();

        Optional<User> user = userService.getUserByPsuid(request.getUserPsuid());

        if (user.isPresent()) {
            response.setText("Здравствуй, " + user.get().getName() + "! Рада снова тебя услышать! " +
                    "Скажи слово \"запустить\" и название календаря для начала работы.");

            calendlyButton.setButton("Подключить Calendly",
                    calendlyOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);

            buttons.add(calendlyButton);
        } else {
            response.setText("Привет! Я твой персональный помощник в планировании дня, скажи \"расскажи о себе\", " +
                    "чтобы немного узнать обо мне.");

            authButton.setButton("Авторизироваться",
                    yandexOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);

            buttons.add(authButton);
        }

        response.setButtons(buttons);

        return response;
    }
}
