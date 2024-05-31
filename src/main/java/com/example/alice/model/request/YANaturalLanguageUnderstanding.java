package com.example.alice.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YANaturalLanguageUnderstanding {
    //Array of the words
    List<String> tokens = new ArrayList<>();

    //Array of the named entities
    List<YAEntity> entities = new ArrayList<>();
}
