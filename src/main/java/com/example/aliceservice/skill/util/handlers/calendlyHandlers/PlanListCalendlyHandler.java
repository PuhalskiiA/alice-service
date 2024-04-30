package com.example.aliceservice.skill.util.handlers.calendlyHandlers;

import com.example.aliceservice.skill.calendars.calendly.Calendly;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.DateParser;
import com.example.aliceservice.skill.util.Sources;
import com.example.aliceservice.skill.util.handlers.CommandHandler;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@CommandHandler(commands = {"дай список дел на сегодня"})
public class PlanListCalendlyHandler extends Handler {
    @Autowired
    private Calendly calendly;

    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = getDefaultResponse(yandexAliceRequest);

        LocalDateTime startTime = LocalDate.now().atStartOfDay();
        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        DateParser dateParser = new DateParser();

        String plans = calendly.getEventsTemporarily(getUserPsuid(yandexAliceRequest), Sources.CALENDLY.toString(),
                dateParser.parseDate(startTime), dateParser.parseDate(endTime)).toString();

        yandexAliceResponse.getResponse().setText("На сегодня у вас запланировано: " + plans);

        return yandexAliceResponse;
    }
}
