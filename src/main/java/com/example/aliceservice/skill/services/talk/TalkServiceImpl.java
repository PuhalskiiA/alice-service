package com.example.aliceservice.skill.services.talk;

import org.springframework.stereotype.Service;

@Service
public class TalkServiceImpl implements TalkService {
    public String saidSelfInformation() {
        return "Я твой персональный помощник в планировании дня. Через меня ты можешь авторизироваться в некоторые календари, " +
                "и совершать операции над своими делами. " +
                "Пока что поддерживается только сервис Calendly, но я работаю над собой!";
    }
}
