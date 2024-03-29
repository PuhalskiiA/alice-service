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
    @ApiModelProperty(required = true)
    @JsonProperty("message_id")
    Integer messageId;

    //Уникальный идентификатор сессии
    @ApiModelProperty(required = true, name = "session_id")
    @JsonProperty("session_id")
    String sessionId;

    //Идентификатор вызываемого навыка
    @ApiModelProperty(required = true)
    @JsonProperty("skill_id")
    String skillId;

    //Данные о пользователе
    @ApiModelProperty
    YAUser user;

    //Данные о приложении
    @ApiModelProperty
    YAApplication application;

    //Признак новой сессии
    @ApiModelProperty(required = true, name = "new")
    boolean isNew;

}
