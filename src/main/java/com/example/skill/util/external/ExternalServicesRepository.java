package com.example.skill.util.external;

import com.example.alice.Alice;
import com.example.alice.model.request.YandexAliceRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExternalServicesRepository {
    Map<Class<?>, ExternalService> externalServices = Map.ofEntries(
            Map.entry(YandexAliceRequest.class, new Alice())
    );

    public CustomResponse getCustomResponse(CustomRequest request) {
        return externalServices.get(request.getClass()).getResponse(request);
    }
}
