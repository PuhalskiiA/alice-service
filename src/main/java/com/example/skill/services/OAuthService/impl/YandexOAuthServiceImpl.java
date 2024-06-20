package com.example.skill.services.OAuthService.impl;

import com.example.skill.exceptions.UserNotFoundException;
import com.example.skill.model.OAuthYandexModels.OAuthResponseTokenBody;
import com.example.skill.model.OAuthYandexModels.OAuthResponseUserBody;
import com.example.skill.model.entityes.User;
import com.example.skill.services.OAuthService.OAuthService;
import com.example.skill.services.tokenService.TokenServiceImpl;
import com.example.skill.services.userService.UserServiceImpl;
import com.example.skill.util.Sources;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class YandexOAuthServiceImpl implements OAuthService {
    RestTemplate restTemplate;
    UserServiceImpl userService;
    TokenServiceImpl tokenService;

    static String clientId = "4d064ceeaa4e4c349f71c95f769f74ee";
    static String clientSecret = "1962fe8464a4404e9259ff1ab0958b59";

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

        UUID localUserID = UUID.randomUUID();

        try {
            Optional<User> user = userService.getUserByPsuid(state);

            if (user.isPresent()) {
                return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
            } else {
                throw new UserNotFoundException("User not found");
            }

        } catch (UserNotFoundException e) {
            userService.addUser(localUserID,
                    userDataResponseBody.getFirstName(),
                    userDataResponseBody.getLastName(),
                    userDataResponseBody.getDefaultEmail(),
                    userDataResponseBody.getSex(),
                    state);
            tokenService.addToken(UUID.randomUUID(),
                    tokenResponseBody.getAccessToken(),
                    tokenResponseBody.getRefreshToken(),
                    localUserID,
                    null,
                    null,
                    Sources.YANDEX.toString());

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @Override
    public String getCodeURL(String userID) {
        String url = "https://oauth.yandex.ru/authorize";
        String responseType = "code";

        String requestUrl = url +
                "?response_type=" + responseType +
                "&client_id=" + clientId +
                "&state=" + userID;

        return requestUrl;
    }
}
