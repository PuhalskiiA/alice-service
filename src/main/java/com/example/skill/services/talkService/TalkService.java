package com.example.skill.services.talkService;

import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;

public interface TalkService {
    CustomResponse talk(CustomRequest request);
}
