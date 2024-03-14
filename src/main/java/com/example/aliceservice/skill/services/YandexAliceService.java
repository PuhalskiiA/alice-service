package com.example.aliceservice.skill.services;

import com.example.aliceservice.skill.entityes.alice.YandexAliceResponse;

public interface YandexAliceService {
    YandexAliceResponse talkYandexAlice(YandexAliceRequest request);
}
