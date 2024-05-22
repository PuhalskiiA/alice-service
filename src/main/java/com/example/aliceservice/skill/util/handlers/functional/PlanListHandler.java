package com.example.aliceservice.skill.util.handlers.functional;

import com.example.aliceservice.skill.calendars.Calendars;
import com.example.aliceservice.skill.calendars.EventInfo;
import com.example.aliceservice.skill.util.handlers.Handler;
import com.example.aliceservice.skill.calendars.calendly.Calendly;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.SourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"дай список дел на сегодня"})
public class PlanListHandler extends Handler {
    @Autowired
    private SourceStateRepository sourceStateRepository;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

//        LocalDateTime startTime = LocalDate.now().atStartOfDay();
//        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
//
//        DateParser dateParser = new DateParser();
//
//        String plans = calendly.getEventsTemporarily(getUserPsuid(yandexAliceRequest), Sources.CALENDLY.toString(),
//                dateParser.parseDate(startTime), dateParser.parseDate(endTime)).toString();

        Calendars calendar = sourceStateRepository.getSource(yandexAliceRequest.getSessionState().getUserState().getState());

        yandexAliceResponse.getResponse().setText("На сегодня у вас запланировано:\n"
                + calendar.getEvents(new EventInfo()));

        return yandexAliceResponse;
    }
}
