package com.example.aliceservice.skill.services.configurationService;

import com.example.aliceservice.skill.exceptions.ConfigurationNotFoundException;
import com.example.aliceservice.skill.model.entityes.Configuration;
import com.example.aliceservice.skill.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public Configuration getConfigByUserId(UUID userId) {
        Optional<Configuration> configuration = Optional.ofNullable(configurationRepository
                .getConfigurationByUserId(userId));

        if (configuration.isPresent()) {
            return configuration.get();
        } else {
            throw new ConfigurationNotFoundException("Configuration not found");
        }
    }
}
