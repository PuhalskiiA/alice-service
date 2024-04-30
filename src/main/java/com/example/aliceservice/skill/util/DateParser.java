package com.example.aliceservice.skill.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DateParser {
    public String getDate() {
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ\"");

        return currentTime.format(formatter);
    }

    public String getIncreasedHourDate() {
        return null;
    }

    public String parseDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("\"yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ\""));
    }
}
