package com.example.aliceservice.skill.util.handlers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommandHandlersRepository {
    Map<String, Handler> handlers = new HashMap<>();

    public CommandHandlersRepository(List<Handler> handlers)  {
        handlers.forEach(commandHandler -> {
            if (commandHandler.getClass().isAnnotationPresent(CommandHandler.class)) {
                String[] commands = commandHandler.getClass().getAnnotation(CommandHandler.class).commands();

                for (String command : commands) {
                    this.handlers.put(command, commandHandler);
                }
            }
        });
    }

    public Handler getHandler(String command) {
        return handlers.get(command);
    }
}
