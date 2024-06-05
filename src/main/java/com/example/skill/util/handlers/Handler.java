package com.example.skill.util.handlers;

import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;

public abstract class Handler {
    public abstract CustomResponse getResponse(CustomRequest request);
}
