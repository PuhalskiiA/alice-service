package com.example.aliceservice.skill.services.yandexService;

import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.request.intents.SelfIntent;
import com.example.aliceservice.skill.model.alice.response.YASkillResponse;
import com.example.aliceservice.skill.model.alice.response.YandexAliceResponse;
import com.example.aliceservice.skill.util.handlers.CommandHandlersRepository;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YandexAliceServiceImpl implements YandexAliceService {
    @Autowired
    private CommandHandlersRepository commandHandlersRepository;

    @Override
    public YandexAliceResponse talkYandexAlice(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse(new YASkillResponse(), null, "1.0");

        Handler handler = commandHandlersRepository.getHandler(yandexAliceRequest.getRequest().getCommand());

        //Command not found
        if (handler == null) {
            yandexAliceResponse.getResponse().setText("Не поняла, попробуй другими словами");
            return yandexAliceResponse;
        }

        if (!yandexAliceRequest.getRequest().getCommand().isEmpty()) {
            SelfIntent selfIntent = (SelfIntent) yandexAliceRequest.getRequest().getNlu().getIntent();

            System.out.println("\n\n\n" + yandexAliceRequest + "\n\n\n");
            System.out.println("\n\n\n" + selfIntent.getSlots().getAction().getValue() + "\n\n\n");
            System.out.println("\n\n\n" + selfIntent.getSlots().getResource().getValue() + "\n\n\n");
        }

        return handler.getResponse(yandexAliceRequest);
    }
}
