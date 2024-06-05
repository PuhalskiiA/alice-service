package com.example.skill.services.talkService;

import com.example.skill.util.externalAssistant.CustomRequest;
import com.example.skill.util.externalAssistant.CustomResponse;

public interface TalkService {
    CustomResponse talk(CustomRequest request);
}
