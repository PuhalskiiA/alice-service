//package com.example.alice.handlers.utils;
//
//import com.example.alice.handlers.ExternalCommandHandler;
//import com.example.alice.handlers.ExternalHandler;
//import com.example.alice.model.request.YandexAliceRequest;
//import com.example.alice.model.response.YAButton;
//import com.example.alice.model.response.YandexAliceResponse;
//import com.example.aliceservice.skill.util.Sources;
//import com.example.skill.services.OAuthService.OAuthService;
//import com.example.skill.util.handlers.CommandHandler;
//import com.example.skill.util.handlers.Handler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@ExternalCommandHandler(commands = {"доступные календари"})
//public class YASourcesHandler extends ExternalHandler {
//    @Autowired
//    private OAuthService oAuthService;
//
//    @Override
//    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
//        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);
//        List<YAButton> buttons = new ArrayList<>();
//
//        List<String> sourcesList = new ArrayList<>();
//
//        for (Sources source : Sources.values()) {
//            if (source != Sources.YANDEX) sourcesList.add(source.toString());
//        }
//
//        yandexAliceResponse.getResponse().setText("Сейчас поддерживаются следующие календари: " +
//                String.join(", ", sourcesList));
//
//        buttons.add(new YAButton("Подключить Calendly",
//                oAuthService.getCodeURL(getUserPsuid(yandexAliceRequest)), true));
//
//        yandexAliceResponse.getResponse().setButtons(buttons);
//
//        return yandexAliceResponse;
//    }
//}
