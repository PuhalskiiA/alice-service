package com.example.aliceservice.skill.model.alice.request;

import java.util.ArrayList;
import java.util.List;

import com.example.aliceservice.skill.model.alice.request.intents.Intent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YANaturalLanguageUnderstanding {
    //Array of the words
    List<String> tokens = new ArrayList<>();

    //Array of the named entities
    List<YAEntity> entities = new ArrayList<>();

    Intent intent;
}
