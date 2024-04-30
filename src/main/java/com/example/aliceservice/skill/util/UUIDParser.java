package com.example.aliceservice.skill.util;

import java.util.UUID;

public class UUIDParser {
    public static UUID parse(String url) {
        String uuidString = url.substring(url.lastIndexOf("/") + 1);

        return UUID.fromString(uuidString);
    }
}
