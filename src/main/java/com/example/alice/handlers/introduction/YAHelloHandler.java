//package com.example.alice.handlers.introduction;
//
//import com.example.alice.handlers.ExternalCommandHandler;
//import com.example.alice.handlers.ExternalHandler;
//import com.example.alice.model.request.YandexAliceRequest;
//import com.example.alice.model.response.YAButton;
//import com.example.alice.model.response.YandexAliceResponse;
//import com.example.skill.model.entityes.User;
//import com.example.skill.services.OAuthService.OAuthService;
//import com.example.skill.services.OAuthService.YandexOAuthService;
//import com.example.skill.services.userService.UserService;
//import com.example.skill.util.handlers.CommandHandler;
//import com.example.skill.util.handlers.Handler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@ExternalCommandHandler(commands = {"", "на главную", "главная", "привет"})
//public class YAHelloHandler extends ExternalHandler {
//    @Autowired
//    @Qualifier("calendlyOAuthServiceImpl")
//    private OAuthService oAuthService;
//
//    @Autowired
//    private YandexOAuthService yandexOAuthService;
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
//        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
//
//        List<YAButton> buttons = new ArrayList<>();
//
//        Optional<User> user = userService.getUserByPsuid(getUserPsuid(yandexAliceRequest));
//
//        if (user.isPresent()) {
//            yandexAliceResponse.getResponse().setText("Здравствуй, " + user.get().getName() + "! Рада снова тебя услышать! " +
//                    "Скажи слово \"запустить\" и название календаря для начала работы.");
//            buttons.add(new YAButton("Подключить Calendly",
//                    oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//        } else {
//            yandexAliceResponse.getResponse().setText("Привет! Я твой персональный помощник в планировании дня, скажи \"расскажи о себе\", " +
//                    "чтобы немного узнать обо мне.");
//
//            buttons.add(new YAButton("Авторизироваться",
//                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//        }
//
//        yandexAliceResponse.getResponse().setButtons(buttons);
//
//        return yandexAliceResponse;
//    }
//}
