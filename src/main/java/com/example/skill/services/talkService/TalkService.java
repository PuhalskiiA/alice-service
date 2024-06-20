package com.example.skill.services.talkService;

import com.example.skill.util.external_assistant.CustomRequest;
import com.example.skill.util.external_assistant.CustomResponse;

public interface TalkService {
    CustomResponse talk(CustomRequest request);
}
