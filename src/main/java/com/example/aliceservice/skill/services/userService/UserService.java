package com.example.aliceservice.skill.services.userService;

import com.example.aliceservice.skill.model.entityes.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    void addUser(UUID id, String name, String surname, String email, String sex, String psuid);

    UUID getIdByPsuid(String psuid);

    Optional<User> getUserByPsuid(String psuid);

    Optional<User> checkSourceForUser(String psuid, String source);
}
