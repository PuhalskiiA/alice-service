package com.example.aliceservice.skill.util.handlers;

import com.example.aliceservice.skill.model.alice.SessionState;
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
                SessionState state = commandHandler.getClass().getAnnotation(CommandHandler.class).state();

                for (String command : commands) {
                    this.handlers.put(command + ":" + state, commandHandler);
                }
            }
        });
    }

    public Handler getHandler(String command) {
        return handlers.get(command);
    }
}
