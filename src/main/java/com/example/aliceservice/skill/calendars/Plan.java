package com.example.aliceservice.skill.calendars;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
    String name;
    String description;
    String date_start;
    String date_end;
    String number;
    String duration;
    String location;
}
