package com.example.aliceservice.skill.services.yandexService;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.*;
import com.example.aliceservice.skill.util.CommandHandlersRepository;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YandexAliceServiceImpl implements YandexAliceService {
    @Autowired
    private CommandHandlersRepository commandHandlersRepository;

    @Override
    public YandexAliceResponse talkYandexAlice(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse(new YASkillResponse(), null, "1.0");
        String command = yandexAliceRequest.getRequest().getCommand();

        Handler handler = commandHandlersRepository.getHandler(command);

        //Command not found
        if (handler == null) {
            yandexAliceResponse.getResponse().setText("Не поняла, попробуй другими словами");
            return yandexAliceResponse;
        }

        YandexAliceResponse handlerResponse = handler.getResponse(yandexAliceRequest);

//        Calendly calendly = new Calendly();
//
//        LocalDateTime startTime = LocalDate.now().atStartOfDay();
//        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
//
//        DateParser dateParser = new DateParser();
//
//        String plans = calendly.getEventsTemporarily(userID, Sources.CALENDLY.toString(),
//                dateParser.parseDate(startTime), dateParser.parseDate(endTime)).toString();
//
//        yandexAliceResponse.getResponse().setText("На сегодня у вас запланировано: " + plans);

//        listOfButtons.add(new YAButton("Подключить Calendly",
//                new CalendlyOAuthServiceImpl().getCodeURL(userID), true));
//        listOfButtons.add(new YAButton("Давай авторизируемся",
//                new YandexOAuthServiceImpl().getCodeURL(applicationID, userID), true));
        
        return handlerResponse;
    }
}
