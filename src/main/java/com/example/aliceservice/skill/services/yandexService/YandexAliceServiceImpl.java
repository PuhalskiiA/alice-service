package com.example.aliceservice.skill.services.yandexService;

import com.example.aliceservice.skill.model.alice.SessionState;
import com.example.aliceservice.skill.model.alice.request.YAState;
import com.example.aliceservice.skill.model.alice.request.YandexAliceRequest;
import com.example.aliceservice.skill.model.alice.request.states.YAUserState;
import com.example.aliceservice.skill.model.alice.response.*;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import com.example.aliceservice.skill.util.handlers.CommandHandlersRepository;
import com.example.aliceservice.skill.util.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YandexAliceServiceImpl implements YandexAliceService {
    @Autowired
    private YandexOAuthService yandexOAuthService;

    @Autowired
    private CommandHandlersRepository commandHandlersRepository;

    @Override
    public YandexAliceResponse talkYandexAlice(YandexAliceRequest yandexAliceRequest) {
        YandexAliceResponse yandexAliceResponse = new YandexAliceResponse(new YASkillResponse(), null, "1.0");
        String command = yandexAliceRequest.getRequest().getCommand();
        SessionState state = yandexAliceRequest.getSessionState().getUserState().getState();

        //Enter point
        if (state == null || command.isEmpty() && state != SessionState.INITIAL) {
            state = SessionState.INITIAL;
            yandexAliceRequest.getSessionState().getUserState().setState(state);
        }

        Handler handler = commandHandlersRepository.getHandler(command + ":" + state);

        if (state == SessionState.AUTHORIZE) {
            List<YAButton> buttons = new ArrayList<>();

            buttons.add(new YAButton("Авторизироваться",
                    yandexOAuthService.getCodeURL(yandexAliceRequest.getSession().getUser().getUserId()), true));

            yandexAliceResponse.getResponse().setText("Нужно авторизироваться, чтобы продолжить общение. " +
                    "Если вы уже это сделали, скажите \"проверить авторизацию\".");
            yandexAliceResponse.getResponse().setButtons(buttons);

            return yandexAliceResponse;
        }

        //Command not found
        if (handler == null) {
            yandexAliceResponse.getResponse().setText("Не поняла, попробуй другими словами");
            return yandexAliceResponse;
        }

        return handler.getResponse(yandexAliceRequest);
    }
}
