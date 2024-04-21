package com.example.aliceservice.skill.services.userService;

import com.example.aliceservice.skill.model.entityes.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    void getTokensForService(UUID uuid);
}
