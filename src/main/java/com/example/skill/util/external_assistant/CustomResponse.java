package com.example.skill.util.external_assistant;

import com.example.skill.model.components.Button;
import com.example.skill.util.SessionState;

import java.util.List;

public abstract class CustomResponse {
    public abstract void setText(String text);
    public abstract void setState(SessionState state);
    public abstract void setButtons(List<Button> buttons);
}
