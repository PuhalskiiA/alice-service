package com.example.skill.util.externalAssistant;

import com.example.skill.util.SessionState;

//@JsonDeserialize(using = CustomRequestDeserializer.class)
public abstract class CustomRequest {
    public abstract String getUserCommand();

    public abstract SessionState getUserSessionState();

    public abstract String getUserPsuid();
}
