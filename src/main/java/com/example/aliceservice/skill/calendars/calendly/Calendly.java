package com.example.aliceservice.skill.calendars.calendly;

import com.example.aliceservice.skill.calendars.calendly.model.availability.Collection;
import com.example.aliceservice.skill.calendars.calendly.model.availability.UserBusyTime;
import com.example.aliceservice.skill.model.entityes.Token;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.services.tokenService.TokenServiceImpl;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class Calendly {
    @Autowired
    private TokenServiceImpl tokenService;

    @Autowired
    private RestTemplate restTemplate;

    public void addEvent(String name, String host, int duration, Date start, Date end, String kindLocation) {
//        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
//
//        requestBody.add("grant_type", "authorization_code");
//        requestBody.add("code", code);
//        requestBody.add("redirect_uri", redirectURI);
//        requestBody.add("state", "1234567890");
//
//        String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.add("Authorization", "Basic " + credentials);
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<OAuthResponseBody> response = restTemplate
//                .postForEntity("https://auth.calendly.com/oauth/token", requestEntity, OAuthResponseBody.class);

    }

    public void updateEvent() {

    }

    public void deleteEvent() {

    }
//
//    @Override
//    public Event getEvent() {
//        return null;
//    }
//
//    @Override
//    public List<Event> getEventsByDay() {
//        return null;
//    }
//

    public Collection getEventsTemporarily(String psuid, String source, String startTime, String endTime) {
        Token token = tokenService.getTokenByPsuidAndSource(psuid, source);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("end_time", endTime);
        requestBody.add("start_time", startTime);
        requestBody.add("user", token.getOwner());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Bearer " + token.getToken());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Collection> response = restTemplate.getForEntity("https://api.calendly.com\n" +
                "/user_busy_times", Collection.class, requestEntity);

        System.out.println("\n\n\n" + response.getBody() + "\n\n\n");

        return response.getBody();
    }
}
