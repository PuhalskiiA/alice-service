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
//Данные о приложении
public class YAApplication {

    //Идентификатор экземпляра приложения, в котором пользователь общается с Алисой
    @JsonProperty("application_id")
    String applicationId;

}
