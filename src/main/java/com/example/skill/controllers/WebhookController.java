package com.example.skill.controllers;

import com.example.voiceAssistants.alice.model.request.YandexAliceRequest;
import com.example.voiceAssistants.alice.model.response.YandexAliceResponse;
import com.example.skill.services.talkService.TalkService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class WebhookController {
    @Autowired
    TalkService talkService;

    @PostMapping(value = "/webhook")
    public YandexAliceResponse receiveWebhook(@RequestBody YandexAliceRequest request) {
        try {
            return (YandexAliceResponse) talkService.talk(request);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }
}
