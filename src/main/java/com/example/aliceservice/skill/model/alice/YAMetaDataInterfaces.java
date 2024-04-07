package com.example.aliceservice.skill.model.alice;

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
    //У пользователя есть возможность запросить связку аккаунтов
    String accountLinking;
    //Пользователь может видеть ответ навыка на экране и открывать ссылки в браузере
    String screen;
    //На устройстве пользователя есть аудиоплеер
    String audio_player;
}
