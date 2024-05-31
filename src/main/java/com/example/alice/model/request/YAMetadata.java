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
public class YAMetadata {
    @JsonProperty("locale")
    String locale;

    @JsonProperty("timezone")
    String timezone;

    @JsonProperty("client_id")
    String clientId;

    @JsonProperty("interfaces")
    YAMetaDataInterfaces interfaces;
}
