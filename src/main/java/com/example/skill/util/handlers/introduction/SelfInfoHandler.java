package com.example.skill.util.handlers.introduction;

import com.example.skill.model.components.Button;
import com.example.skill.model.components.URLButton;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;
import com.example.skill.util.external_assistant.ExternalService;
import com.example.skill.util.external_assistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CommandHandler(commands = {"расскажи себе", "поведай себе", "расскажи себя"})
public class SelfInfoHandler extends Handler {
    OAuthService calendlyOAuthServiceImpl;
    OAuthService yandexOAuthServiceImpl;
    ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
        ExternalService externalService = externalServicesRepository.getService(request);

        List<Button> buttons = new ArrayList<>();

        URLButton authButton = externalService.getURLButton();
        URLButton calendlyButton = externalService.getURLButton();

        response.setText("Я твой персональный помощник в планировании дня. " +
                "Через меня ты можешь авторизироваться в некоторые календари и совершать операции над своими задачами. " +
                "Пока что поддерживается только сервис Calendly, но я работаю над собой! Чтобы персонализировать общение, " +
                "а также добавить календари, нужно авторизироваться через чат со мной.");

        authButton.setButton("Авторизироваться",
                yandexOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);

        calendlyButton.setButton("Подключить Calendly",
                calendlyOAuthServiceImpl.getCodeURL(request.getUserPsuid()), true);

        buttons.add(authButton);
        buttons.add(calendlyButton);

        response.setButtons(buttons);

        return response;
    }
}
