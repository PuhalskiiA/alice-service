package com.example.voice_assistants.alice;

import com.example.skill.model.components.DefaultButton;
import com.example.skill.model.components.URLButton;
import com.example.skill.util.external_utils.external_assistant.CustomRequest;
import com.example.skill.util.external_utils.external_assistant.CustomResponse;
import com.example.skill.util.external_utils.external_assistant.ExternalService;
import com.example.voice_assistants.alice.model.request.YandexAliceRequest;
import com.example.voice_assistants.alice.model.response.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AliceService extends ExternalService {
    @Override
    public CustomResponse getResponse(CustomRequest request) {
        return new YandexAliceResponse(new YASkillResponse(),
                new YAResponseSessionState(request.getUserSessionState()), "1.0");
    }

    @Override
    public Class<?> getRequestClass() {
        return YandexAliceRequest.class;
    }

    @Override
    public DefaultButton getDefaultButton() {
        return new YADefaultButton();
    }

    @Override
    public URLButton getURLButton() {
        return new YAURLButton();
    }
}
