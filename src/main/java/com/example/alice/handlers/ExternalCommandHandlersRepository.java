package com.example.alice.handlers;

import com.example.skill.util.handlers.CommandHandler;
import com.example.skill.util.handlers.Handler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExternalCommandHandlersRepository {
    Map<String, Handler> handlers = new HashMap<>();

    public ExternalCommandHandlersRepository(List<Handler> handlers)  {
        handlers.forEach(externalCommandHandler -> {
            if (externalCommandHandler.getClass().isAnnotationPresent(ExternalCommandHandler.class)) {
                String[] commands = externalCommandHandler.getClass()
                        .getAnnotation(ExternalCommandHandler.class).commands();

                for (String command : commands) {
                    this.handlers.put(command, externalCommandHandler);
                }
            }
        });
    }

    public Handler getHandler(String command) {
        return handlers.get(command);
    }
}
