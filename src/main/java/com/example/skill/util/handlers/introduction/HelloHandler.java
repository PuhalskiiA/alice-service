package com.example.skill.util.handlers.introduction;

import com.example.skill.model.entityes.User;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.services.userService.UserService;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalServicesRepository;
import com.example.skill.util.handlers.Handler;
import com.example.skill.services.OAuthService.YandexOAuthService;
import com.example.skill.util.handlers.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommandHandler(commands = {"", "на главную", "главная", "привет"})
public class HelloHandler extends Handler {
    @Autowired
    @Qualifier("calendlyOAuthServiceImpl")
    private OAuthService oAuthService;

    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExternalServicesRepository externalServicesRepository;

    @Override
    public CustomResponse getResponse(CustomRequest request) {
        CustomResponse response = externalServicesRepository.getCustomResponse(request);

        Optional<User> user = userService.getUserByPsuid(request.getUserPsuid());

        if (user.isPresent()) {
            response.setText("Здравствуй, " + user.get().getName() + "! Рада снова тебя услышать! " +
                    "Скажи слово \"запустить\" и название календаря для начала работы.");
        } else {
            response.setText("Привет! Я твой персональный помощник в планировании дня, скажи \"расскажи о себе\", " +
                    "чтобы немного узнать обо мне.");
        }

        //            buttons.add(new YAButton("Авторизироваться",
//                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
        //            buttons.add(new YAButton("Подключить Calendly",
//                    oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
        //        List<YAButton> buttons = new ArrayList<>();
//        yandexAliceResponse.getResponse().setButtons(buttons);

        return response;
    }
}
