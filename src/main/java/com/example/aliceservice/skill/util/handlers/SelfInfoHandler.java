package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import org.springframework.stereotype.Service;

@Service
@CommandHandler(commands = {"asd", "asd"})
public class SelfInfoHandler extends Handler {
    @Override
    public YandexAliceResponse getResponse(YandexAliceRequest yandexAliceRequest) {
        YASkillResponse skillResponse = new YASkillResponse();

        skillResponse.setText("Я твой персональный помощник в планировании дня. " +
                "Через меня ты можешь авторизироваться в некоторые календари и совершать операции над своими задачами. " +
                "Пока что поддерживается только сервис Calendly, но я работаю над собой!");

        return new YandexAliceResponse(skillResponse, null, "1.0");
    }
}
