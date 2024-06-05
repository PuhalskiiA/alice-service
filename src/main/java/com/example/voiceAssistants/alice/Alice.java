package com.example.voiceAssistants.alice;

import com.example.skill.model.components.DefaultButton;
import com.example.skill.model.components.URLButton;
import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;
import com.example.skill.util.externalAssistant.ExternalService;
import com.example.voiceAssistants.alice.model.response.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Alice extends ExternalService {
    @Override
    public CustomResponse getResponse(CustomRequest request) {
        return new YandexAliceResponse(new YASkillResponse(),
                new YAResponseSessionState(request.getUserSessionState()), "1.0");
    }

    @Override
    public <T extends DefaultButton> T getDefaultButton() {
        return (T) new YADefaultButton();
    }

    @Override
    public <T extends URLButton> T getURLButton() {
        return (T) new YAURLButton();
    }
}
