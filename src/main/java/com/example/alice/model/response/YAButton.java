package com.example.alice.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAButton {
    //Named of button
    String title;

    //Button pressed redirect url
    String url = "";

    //Hide button or not
    boolean hide;
}
