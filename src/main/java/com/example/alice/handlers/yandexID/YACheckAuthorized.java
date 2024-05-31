//package com.example.alice.handlers.yandexID;
//
//import com.example.alice.handlers.ExternalCommandHandler;
//import com.example.alice.handlers.ExternalHandler;
//import com.example.alice.model.request.YandexAliceRequest;
//import com.example.alice.model.response.YAButton;
//import com.example.alice.model.response.YandexAliceResponse;
//import com.example.skill.model.entityes.User;
//import com.example.skill.services.OAuthService.YandexOAuthService;
//import com.example.skill.services.userService.UserService;
//import com.example.skill.util.external.CustomResponse;
//import com.example.skill.util.handlers.CommandHandler;
//import com.example.skill.util.handlers.Handler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@ExternalCommandHandler(commands = {"проверить авторизацию"})
//public class YACheckAuthorized extends ExternalHandler {
//    @Autowired
//    private YandexOAuthService yandexOAuthService;
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
//        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
//        List<YAButton> buttons = new ArrayList<>();
//
//        Optional<User> user = userService.getUserByPsuid(getUserPsuid(yandexAliceRequest));
//
//        if (user.isPresent()) {
//            yandexAliceResponse.getResponse().setText(user.get().getName() + ", все прошло успешно!");
//        } else {
//            yandexAliceResponse.getResponse().setText("Что то пошло не так:( Попробуй снова.");
//
//            buttons.add(new YAButton("Авторизироваться",
//                    yandexOAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//            yandexAliceResponse.getResponse().setButtons(buttons);
//        }
//
//        return yandexAliceResponse;
//    }
//
//    @Override
//    public CustomResponse getAddition(CustomResponse response) {
//        return null;
//    }
//}
