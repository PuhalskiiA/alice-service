package com.example.aliceservice.skill.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WebhookController {

    @PostMapping(value = "/webhook", consumes = "application/json")
    public ResponseEntity<String> receiveWebhook(@RequestBody String payload) {
        try {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "???");
        }
    }

}
