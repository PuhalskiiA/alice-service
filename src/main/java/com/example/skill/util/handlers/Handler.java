package com.example.skill.util.handlers;

import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;

public abstract class Handler {
    public abstract CustomResponse getResponse(CustomRequest request);
}
