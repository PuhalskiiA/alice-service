package com.example.skill.util.external_utils.external_assistant;

import com.example.skill.model.components.DefaultButton;
import com.example.skill.model.components.URLButton;

public abstract class ExternalService {
    public abstract CustomResponse getResponse(CustomRequest request);
    public abstract Class<?> getRequestClass();
    public abstract DefaultButton getDefaultButton();
    public abstract URLButton getURLButton();
}
