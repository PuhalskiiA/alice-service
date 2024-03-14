package com.example.aliceservice.skill.entityes.alice;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAToken {

    Integer start;
    Integer end;

}
