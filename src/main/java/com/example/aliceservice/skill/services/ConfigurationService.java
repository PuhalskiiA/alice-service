package com.example.aliceservice.skill.services;

import com.example.aliceservice.skill.model.entityes.Configuration;

import java.util.UUID;

public interface ConfigurationService {
    Configuration getConfigByUserId(UUID userId);
}
