package com.example.skill.util.handlers;

import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;

public abstract class Handler {
    public abstract CustomResponse getResponse(CustomRequest request);
}
