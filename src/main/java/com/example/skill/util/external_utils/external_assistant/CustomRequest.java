package com.example.skill.util.external_utils.external_assistant;

import com.example.skill.util.external_utils.SessionState;

public abstract class CustomRequest {
    public abstract String getUserCommand();
    public abstract SessionState getUserSessionState();
    public abstract String getUserPsuid();
}
