package com.example.alice.model.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAEntity {
    //Marking the beginning and end of a named entity in a word array
    YAToken token;

    //Type of the named entity
    String type;

    //Formal description of a named entity
    JsonNode value;
}
