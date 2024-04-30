package com.example.aliceservice.skill.controllers;

import com.example.aliceservice.skill.exceptions.UserNotFoundException;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.services.userService.UserServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/get/{uuid}")
    public ResponseEntity<User> getUser(@PathVariable("uuid") UUID uuid) {
        try {
            return new ResponseEntity<>(userService.getUserById(uuid), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.toString());
        }
    }

    @GetMapping(value = "/get/{psuid}")
    public ResponseEntity<Optional<User>> getUserByPsuid(@PathVariable("psuid") String psuid) {
        try {
            return new ResponseEntity<>(userService.getUserByPsuid(psuid), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.toString());
        }
    }

//    @PostMapping(value = "/get_tokens/{uuid}")
//    public void getTokensForService(@PathVariable("uuid") UUID uuid) {
//        try {
//            userService.getUserById(uuid);
//        } catch (UserNotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "???");
//        }
//    }
}
