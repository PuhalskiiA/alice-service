package com.example.voice_assistants.alice.model.response;

import com.example.skill.model.components.DefaultButton;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YADefaultButton implements DefaultButton {
    String title;

    boolean hide;

    @Override
    public void setButton(String title, boolean hide) {
        this.title = title;
        this.hide = hide;
    }
}