package com.example.aliceservice.skill.controllers;

import com.example.aliceservice.skill.model.entityes.Token;
import com.example.aliceservice.skill.services.tokenService.TokenServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
//@RequestMapping("/token")
public class TokenController {
    @Autowired
    TokenServiceImpl tokenService;


//    @PostMapping("/token")
//    public ResponseEntity<Token> getTokenByUserID(@PathVariable UUID id) {
//        try {
//            return new ResponseEntity<>(tokenService.getTokenByUserID(id), HttpStatus.OK);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }

}
