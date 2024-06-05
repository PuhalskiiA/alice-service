package com.example.skill.util.externalAssistant;

import com.example.skill.model.components.DefaultButton;
import com.example.skill.model.components.URLButton;

public abstract class ExternalService {
    public abstract CustomResponse getResponse(CustomRequest request);

    public abstract <T extends DefaultButton> T getDefaultButton();

    public abstract <T extends URLButton> T getURLButton();
}
