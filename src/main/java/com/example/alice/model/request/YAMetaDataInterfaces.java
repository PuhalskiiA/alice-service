package com.example.alice.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAMetaDataInterfaces {
    //Account linking of the user
    String accountLinking;

    //User has a screen
    String screen;

    //User has a audio
    String audio_player;
}
