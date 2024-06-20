package com.example.skill.controllers;

import com.example.voice_assistants.alice.model.request.YandexAliceRequest;
import com.example.voice_assistants.alice.model.response.YandexAliceResponse;
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
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WebhookController {
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
