package com.example.aliceservice.skill.controllers;

import com.example.aliceservice.skill.services.talk.TalkServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequestMapping(value = "/talk")
public class TalkController {
    @Autowired
    private TalkServiceImpl talkService;

    @GetMapping("/self_info")
    public void saidSelfInfo() {
        talkService.saidSelfInformation();
    }

}
