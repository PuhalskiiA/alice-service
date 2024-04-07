package com.example.aliceservice.skill.model.alice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonDeserialize(builder = YAMetadata.YAMetadataBuilder.class)
@Builder
//Информация об устройстве, с помощью которого пользователь разговаривает с Алисой
public class YAMetadata {
    //Язык в POSIX-формате
    String locale;

    //Название часового пояса, включая алиасы
    String timezone;

    //Идентификатор устройства и приложения, в котором идет разговор
    @JsonProperty("client_id")
    String clientId;

    //Интерфейсы, доступные на устройстве пользователя
    YAMetaDataInterfaces interfaces;
}
