package com.example.aliceservice.skill.exceptions;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String msg) {
        super(msg);
    }
}
