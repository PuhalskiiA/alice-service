package com.example.voiceAssistants.alice.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

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
