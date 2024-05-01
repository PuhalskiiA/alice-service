package com.example.aliceservice.skill.services.yandexService;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YAState;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.request.states.YAUserState;
import com.example.aliceservice.skill.model.alice.response.*;
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
        String command = yandexAliceRequest.getRequest().getCommand();
        SessionState state = yandexAliceRequest.getSessionState().getUserState().getState();

        //Enter point
        if (state == null) {
            state = SessionState.INITIAL;
            yandexAliceRequest.setSessionState(new YAState(null, new YAUserState(state), null));
        }

        Handler handler = commandHandlersRepository.getHandler(command + ":" + state);

        //Command not found
        if (handler == null) {
            yandexAliceResponse.getResponse().setText("Не поняла, попробуй другими словами");
            return yandexAliceResponse;
        }

        return handler.getResponse(yandexAliceRequest);
    }
}
