package com.thejoa703.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiModeration {
    @Value("${openai.api.key}")
    private String apiKey;
    private static final String API_URL = "https://api.openai.com/v1/moderations";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public boolean detectBadWords(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "omni-moderation-latest");
        body.put("input", text);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(API_URL, requestEntity, String.class);
            JsonNode root = objectMapper.readTree(response.getBody());
            return root.path("results").get(0).path("flagged").asBoolean();
        } catch (Exception e) {
            return false; // 에러 시 기본적으로 통과 (상황에 따라 변경 가능)
        }
    }
}