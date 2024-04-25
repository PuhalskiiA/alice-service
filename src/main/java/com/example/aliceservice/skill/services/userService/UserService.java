package com.example.aliceservice.skill.services.userService;

import com.example.aliceservice.skill.model.entityes.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    void addUser(UUID id, String name, String surname, String email, String sex, String psuid, String applicationID);

    UUID getIdByPsuid(String psuid);

    User getUserByPsuid(String psuid);
}
