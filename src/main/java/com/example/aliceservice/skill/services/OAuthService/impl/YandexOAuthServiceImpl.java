package com.example.aliceservice.skill.services.OAuthService.impl;

import com.example.aliceservice.skill.model.OAuthModels.yandex.OAuthResponseTokenBody;
import com.example.aliceservice.skill.model.OAuthModels.yandex.OAuthResponseUserBody;
import com.example.aliceservice.skill.services.OAuthService.YandexOAuthService;
import com.example.aliceservice.skill.services.tokenService.TokenServiceImpl;
import com.example.aliceservice.skill.services.userService.UserServiceImpl;
import com.example.aliceservice.skill.util.Sources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class YandexOAuthServiceImpl implements YandexOAuthService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TokenServiceImpl tokenService;

    private final static String clientId = "4d064ceeaa4e4c349f71c95f769f74ee";
    private final static String clientSecret = "1962fe8464a4404e9259ff1ab0958b59";

    @Override
    public ResponseEntity<String> authenticate(String code, String state) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("grant_type", "authorization_code");
        requestBody.add("code", code);
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);

        String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + credentials);

        HttpEntity<MultiValueMap<String, String>> tokenRequestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<OAuthResponseTokenBody> tokenResponse = restTemplate.postForEntity("https://oauth.yandex.ru/token",
                tokenRequestEntity, OAuthResponseTokenBody.class);

        requestBody.clear();
        headers.clear();

        requestBody.add("format", "json");
        headers.add("Authorization", "OAuth " + tokenResponse.getBody().getAccessToken());

        HttpEntity<MultiValueMap<String, String>> userDataRequestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<OAuthResponseUserBody> userDataResponse = restTemplate.postForEntity("https://login.yandex.ru/info?",
                userDataRequestEntity, OAuthResponseUserBody.class);

        OAuthResponseUserBody userDataResponseBody = userDataResponse.getBody();
        OAuthResponseTokenBody tokenResponseBody = tokenResponse.getBody();

        Map<String, String> ids = parseState(state);
        String applicationID = ids.get("applicationID");
        String userID = ids.get("userID");
        UUID localUserID = UUID.randomUUID();

        userService.addUser(localUserID,
                userDataResponseBody.getFirstName(),
                userDataResponseBody.getLastName(),
                userDataResponseBody.getDefaultEmail(),
                userDataResponseBody.getSex(),
                userID,
                applicationID);
        tokenService.addToken(UUID.randomUUID(),
                tokenResponseBody.getAccessToken(),
                tokenResponseBody.getRefreshToken(),
                localUserID,
                null,
                Sources.YANDEX.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public String getCodeURL(String applicationID, String userID) {
        String url = "https://oauth.yandex.ru/authorize";
        String responseType = "code";

        String requestUrl = url +
                "?response_type=" + responseType +
                "&client_id=" + clientId +
                "&state=" + applicationID + ":" + userID;

        return requestUrl;
    }

    private Map<String, String> parseState(String state) {
        String[] parts = state.split(":");

        Map<String, String> result = new HashMap<>();

        result.put("applicationID", parts[0]);
        result.put("userID", parts[1]);

        return result;
    }
}
