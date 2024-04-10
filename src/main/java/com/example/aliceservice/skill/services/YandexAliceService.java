package com.example.aliceservice.skill.services;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;

public interface YandexAliceService {
    YandexAliceResponse talkYandexAlice(YandexAliceRequest request);
}
