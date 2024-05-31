package com.example.skill.util.external;

import com.example.alice.util.SessionState;

public abstract class CustomResponse {
    public abstract void setText(String text);
    public abstract void setState(SessionState state);
}
