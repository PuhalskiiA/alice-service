package com.example.aliceservice.skill.model.alice.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAToken {
    //First word of the named entity
    Integer start;

    //First word after the named entity
    Integer end;
}
