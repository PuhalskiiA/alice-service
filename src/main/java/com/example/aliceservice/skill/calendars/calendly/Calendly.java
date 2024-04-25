package com.example.aliceservice.skill.calendars.calendly;

import com.example.aliceservice.skill.calendars.ICalendar;
import com.example.aliceservice.skill.calendars.model.Event;
import com.example.aliceservice.skill.model.OAuthModels.calendly.OAuthResponseBody;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;
import java.util.Date;
import java.util.List;

public class Calendly {
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
//    @Override
//    public List<Event> getEventsTemporarily() {
//        return null;
//    }
}
