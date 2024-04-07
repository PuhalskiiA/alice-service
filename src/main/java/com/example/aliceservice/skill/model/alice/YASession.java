package com.example.aliceservice.skill.model.alice;

import com.fasterxml.jackson.annotation.JsonProperty;
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
//Данные о сессии
public class YASession {

    //Идентификатор сообщения в рамках сессии
    @JsonProperty("message_id")
    Integer messageId;

    //Уникальный идентификатор сессии
    @JsonProperty("session_id")
    String sessionId;

    //Идентификатор вызываемого навыка
    @JsonProperty("skill_id")
    String skillId;

    //Данные о пользователе
    YAUser user;

    //Данные о приложении
    YAApplication application;

    //Признак новой сессии
    boolean isNew;

}
