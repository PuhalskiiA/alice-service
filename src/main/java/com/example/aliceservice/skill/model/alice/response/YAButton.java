package com.example.aliceservice.skill.model.alice.response;

import io.swagger.annotations.ApiModelProperty;
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
