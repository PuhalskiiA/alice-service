package com.example.aliceservice.skill.services;

import com.example.aliceservice.skill.model.entityes.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
