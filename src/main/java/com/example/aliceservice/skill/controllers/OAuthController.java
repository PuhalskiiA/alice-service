package com.example.aliceservice.skill.controllers;

import com.example.aliceservice.skill.services.OAuthService.impl.CalendlyOAuthServiceImpl;
import com.example.aliceservice.skill.services.OAuthService.impl.OAuthServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequestMapping(value = "/oauth")
public class OAuthController {
    @Autowired
    private OAuthServiceImpl oAuthService;

    @Autowired
    private CalendlyOAuthServiceImpl calendlyOAuthService;

    @GetMapping(value = "/yandexID")
    public ResponseEntity<String> authenticateYAID(@RequestParam("code") String code) {
        try {
            return oAuthService.authenticate(code);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/calendly")
    public ResponseEntity<String> authenticateCalendly(@RequestParam("code") String code) {
        try {
            return calendlyOAuthService.authenticate(code);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
