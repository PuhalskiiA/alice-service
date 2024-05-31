package com.example.alice;

import com.example.alice.model.response.YAResponseSessionState;
import com.example.alice.model.response.YASkillResponse;
import com.example.alice.model.response.YandexAliceResponse;
import com.example.skill.util.external.CustomRequest;
import com.example.skill.util.external.CustomResponse;
import com.example.skill.util.external.ExternalService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Alice extends ExternalService {
    YASkillResponse skillResponse = new YASkillResponse();
    
    @Override
    public CustomResponse getResponse(CustomRequest request) {
        return new YandexAliceResponse(skillResponse, new YAResponseSessionState(request.getUserSessionState()), "1.0");
    }
}
