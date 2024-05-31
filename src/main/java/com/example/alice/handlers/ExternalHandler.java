package com.example.alice.handlers;

import com.example.skill.util.external.CustomResponse;

public abstract class ExternalHandler {
    public abstract CustomResponse getAddition(CustomResponse response);
}
