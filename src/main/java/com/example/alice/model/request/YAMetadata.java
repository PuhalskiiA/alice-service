package com.example.alice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonDeserialize(builder = YAMetadata.YAMetadataBuilder.class)
@Builder
//Информация об устройстве, с помощью которого пользователь разговаривает с Алисой
public class YAMetadata {
    //Language in POSIX-format
    String locale;

    //Time zone name
    String timezone;

    //Device and app identifier
    @JsonProperty("client_id")
    String clientId;

    //User apply interfaces
    YAMetaDataInterfaces interfaces;
}
