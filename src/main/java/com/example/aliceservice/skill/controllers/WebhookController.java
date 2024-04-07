package com.example.aliceservice.skill.controllers;

import com.example.aliceservice.skill.model.alice.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.YandexAliceResponse;
import com.example.aliceservice.skill.services.servicesImpl.YandexAliceServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Slf4j
public class WebhookController {
    @Autowired
    private YandexAliceServiceImpl aliceService;

    @PostMapping(value = "/webhook")
    public YandexAliceResponse receiveWebhook(@RequestBody YandexAliceRequest request) {
        try {
            return aliceService.talkYandexAlice(request);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "???");
        }
    }

}
