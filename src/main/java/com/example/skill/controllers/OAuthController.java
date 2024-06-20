package com.example.skill.controllers;

import com.example.skill.services.OAuthService.impl.CalendlyOAuthServiceImpl;
import com.example.skill.services.OAuthService.impl.YandexOAuthServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = "/oauth")
public class OAuthController {
    YandexOAuthServiceImpl yandexOAuthService;
    CalendlyOAuthServiceImpl calendlyOAuthService;

    @GetMapping(value = "/yandex_id")
    public ResponseEntity<String> authenticateYAID(@RequestParam("code") String code,
                                                   @RequestParam("state") String state) {
        try {
            return yandexOAuthService.authenticate(code, state);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping(value = "/calendly")
    public ResponseEntity<String> authenticateCalendly(@RequestParam("code") String code,
                                                       @RequestParam("state") String state) {
        try {
            return calendlyOAuthService.authenticate(code, state);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
