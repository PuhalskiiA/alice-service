package com.example.voiceAssistants.alice.model.response;

import com.example.skill.model.components.URLButton;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YAURLButton implements URLButton {
    //Named of button
    String title;

    //Button pressed redirect url
    String url = "";

    //Hide button or not
    boolean hide;

    @Override
    public void setButton(String title, String url, boolean hide) {
        this.title = title;
        this.url = url;
        this.hide = hide;
    }
}
