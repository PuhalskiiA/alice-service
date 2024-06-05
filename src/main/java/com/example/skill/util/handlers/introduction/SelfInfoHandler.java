package com.example.skill.util.handlers.introduction;

import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;
import com.example.skill.util.externalAssistant.ExternalServicesRepository;
import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"расскажи себе", "поведай себе", "расскажи себя"})
public class SelfInfoHandler extends Handler {
    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Autowired
    @Qualifier("yandexOAuthServiceImpl")
    private OAuthService yandexOAuthService;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);
//
//        List<YAButton> buttons = new ArrayList<>();

        response.setText("Я твой персональный помощник в планировании дня. " +
                "Через меня ты можешь авторизироваться в некоторые календари и совершать операции над своими задачами. " +
                "Пока что поддерживается только сервис Calendly, но я работаю над собой! Чтобы персонализировать общение, " +
                "а также добавить календари, нужно авторизироваться через чат со мной.");

//        buttons.add(new YAButton("Авторизироваться",
//                yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//        buttons.add(new YAButton("Подключить Calendly",
//                oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//        yandexAliceResponse.getResponse().setButtons(buttons);

        return response;
    }
}
