package com.example.aliceservice.skill.model.alice;

import com.fasterxml.jackson.annotation.JsonProperty;
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
//Информация об устройстве, с помощью которого пользователь разговаривает с Алисой
public class YAMetadata {

    //Язык в POSIX-формате
    @ApiModelProperty(required = true)
    String locale;

    //Название часового пояса, включая алиасы
    @ApiModelProperty(required = true)
    String timezone;

    //Идентификатор устройства и приложения, в котором идет разговор
    @JsonProperty("client_id")
    @ApiModelProperty(name = "client_id")
    String clientId;

    //Интерфейсы, доступные на устройстве пользователя
    @ApiModelProperty(required = true)
    YAMetaDataInterfaces interfaces;

}
