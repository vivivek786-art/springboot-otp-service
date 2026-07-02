package com.otp.vivek.controller.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class AndroidSmsProvider implements SmsProvider {

    @Value("${sms.gateway.url}")
    private String smsUrl;

    @Value("${sms.gateway.api.key}")
    private String apiKey;

    @Override
    public void sendSms(String mobile, String message) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-API-Key", apiKey);

        Map<String, String> body = new HashMap<>();
        body.put("phoneNumber", "+91" + mobile);
        body.put("message", message);

        HttpEntity<Map<String, String>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(
                        smsUrl,
                        request,
                        String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }
}
