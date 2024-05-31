//package com.example.alice.handlers.calandly;
//
//import com.example.alice.handlers.ExternalCommandHandler;
//import com.example.alice.handlers.ExternalHandler;
//import com.example.skill.model.components.Button;
//import com.example.skill.model.entityes.User;
//import com.example.skill.services.OAuthService.OAuthService;
//import com.example.skill.services.userService.UserService;
//import com.example.skill.util.external.CustomRequest;
//import com.example.skill.util.external.CustomResponse;
//import com.example.skill.util.external.ExternalServicesRepository;
//import com.example.skill.calendars.Sources;
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
//@ExternalCommandHandler(commands = {"проверь подключение к calandly"})
//public class YACheckCalandlyHandler extends ExternalHandler {
//    @Override
//    public CustomResponse getResponse(CustomRequest request) {
//        CustomResponse response = externalServicesRepository.getCustomResponse(request);
//
//        List<Button> buttons = new ArrayList<>();
//
//        Optional<User> user = userService.checkSourceForUser(request.getPsuid(), Sources.CALENDLY.toString());
//
//        if (user.isPresent()) {
//            response.setText(user.get().getName() + ", все получилось!");
//        } else {
//            buttons.add(new Button("Подключить Calendly",
//                    oAuthService.getCodeURL(request.getPsuid()), true));
//
//            response.setText("Что то пошло не так:( Попробуй снова.");
//            response.setButtons(buttons);
//        }
//
//        return yandexAliceResponse;
//    }
//}
