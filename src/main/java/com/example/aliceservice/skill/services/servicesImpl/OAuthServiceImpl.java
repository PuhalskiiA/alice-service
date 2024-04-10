package com.example.aliceservice.skill.services.servicesImpl;

import com.example.aliceservice.skill.services.OAuthService;
import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class OAuthServiceImpl implements OAuthService {
//    @Value("${oauth.clientId}")
    private final String clientId = "4d064ceeaa4e4c349f71c95f769f74ee";
    private final String clientSecret = "1962fe8464a4404e9259ff1ab0958b59";

    @Override
    public ResponseEntity<String> authenticate(String code) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("grant_type", "authorization_code");
        requestBody.add("code", code);
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        headers.add("Authorization", "Basic " + credentials);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://oauth.yandex.ru", requestEntity, String.class);


        return responseEntity;
    }

    @Override
    public String getUrl() {
        String url = "https://oauth.yandex.ru/authorize";
        String responseType = "code";

        StringBuilder requestUrl = new StringBuilder(url);
        requestUrl.append("?response_type=").append(responseType);
        requestUrl.append("&client_id=").append(clientId);

        System.out.println("\n\n\n" + requestUrl + "\n\n\n");

        return requestUrl.toString();
    }
}
