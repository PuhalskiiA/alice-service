package com.example.aliceservice.skill.services;

import com.example.aliceservice.skill.model.alice.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.YandexAliceResponse;

public interface YandexAliceService {
    YandexAliceResponse talkYandexAlice(YandexAliceRequest request);
}
