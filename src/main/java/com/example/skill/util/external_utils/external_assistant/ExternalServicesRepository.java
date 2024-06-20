package com.example.skill.util.external_utils.external_assistant;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExternalServicesRepository {
    Map<Class<?>, ExternalService> externalServicesMap = new HashMap<>();

    public ExternalServicesRepository(List<ExternalService> externalServices) {
        for (ExternalService externalService : externalServices) {
            externalServicesMap.put(externalService.getRequestClass(), externalService);
        }
    }

    public CustomResponse getCustomResponse(CustomRequest request) {
        return externalServicesMap.get(request.getClass()).getResponse(request);
    }

    public ExternalService getService(CustomRequest request) {
        return externalServicesMap.get(request.getClass());
    }
}
