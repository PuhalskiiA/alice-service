package com.example.aliceservice.skill.entityes.alice;

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
public class YASkillResponse {

    @ApiModelProperty(required = true)
    String text;

    @ApiModelProperty
    String tts; //???

    @ApiModelProperty
    List<YAButton> buttons;

    @ApiModelProperty(required = true, name = "end_session")
    @JsonProperty("end_session")
    boolean endSession;

}
