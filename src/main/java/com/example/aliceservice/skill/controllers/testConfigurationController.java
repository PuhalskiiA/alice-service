package com.example.aliceservice.skill.controllers;

import com.example.aliceservice.skill.services.ConfigurationService;
import com.example.aliceservice.skill.services.servicesImpl.ConfigurationServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequestMapping(value = "/config")
public class testConfigurationController {
    @Autowired
    private ConfigurationServiceImpl configurationService;

}
