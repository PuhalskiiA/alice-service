package com.example.skill.util.external;

import com.example.alice.util.SessionState;

//@JsonDeserialize(using = CustomRequestDeserializer.class)
public abstract class CustomRequest {
    public abstract String getUserCommand();

    public abstract SessionState getUserSessionState();

    public abstract String getUserPsuid();
}
