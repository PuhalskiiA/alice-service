package com.example.aliceservice.skill.services.OAuthService.impl;

import com.example.aliceservice.skill.model.OAuthModels.calendly.OAuthResponseBody;
import com.example.aliceservice.skill.services.OAuthService.OAuthService;
import com.example.aliceservice.skill.services.tokenService.TokenServiceImpl;
import com.example.aliceservice.skill.util.Sources;
import com.example.aliceservice.skill.util.UUIDParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.UUID;

@Service
public class CalendlyOAuthServiceImpl implements OAuthService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TokenServiceImpl tokenService;

    private final String clientId = "kTYiuXubdTDCaC7QkJsGJjFcLS7NGQ4yInlnoI6TAdI";
    private final String clientSecret = "Qu8Q4AjG0kr4tbhucsXF8BwdhvhGUBYHgKuNlQ7TXio";
    private final String redirectURI = "https://dateplan.ru/oauth/calendly";

    @Override
    public ResponseEntity<String> authenticate(String code) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("grant_type", "authorization_code");
        requestBody.add("code", code);
        requestBody.add("redirect_uri", redirectURI);

        String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + credentials);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<OAuthResponseBody> response = restTemplate
                .postForEntity("https://auth.calendly.com/oauth/token", requestEntity, OAuthResponseBody.class);

        tokenService.addToken(UUID.randomUUID(),
                response.getBody().getAccessToken(),
                response.getBody().getRefreshToken(),
                UUIDParser.parse(response.getBody().getOwner()),
                UUIDParser.parse(response.getBody().getOrganization()),
                Sources.CALENDLY.toString());

        return new ResponseEntity<>(response.toString(), response.getStatusCode());
    }

    @Override
    public String getCodeURL() {
        String url = "https://auth.calendly.com/oauth/authorize";
        String responseType = "code";

        String requestUrl = url + "?client_id=" + clientId + "&response_type=" + responseType +
                "&redirect_uri=" + redirectURI;

        return requestUrl;
    }
}
