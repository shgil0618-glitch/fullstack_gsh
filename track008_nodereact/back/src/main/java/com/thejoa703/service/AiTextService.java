package com.thejoa703.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AiTextService {
    @Value("${openai.api.key}")
    private String apiKey;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private final ObjectMapper mapper = new ObjectMapper();

    // 레시피 설명 생성
    public String generateDescription(String title, List<String> ingredients, List<String> steps) {
        String prompt = String.format("제목: %s\n재료: %s\n단계: %s\n위 내용을 바탕으로 요리 설명을 자연스럽게 작성해줘.", 
                        title, String.join(", ", ingredients), String.join(" / ", steps));
        return callGpt(prompt);
    }

    // 조리 단계 자동 생성
    public String generateSteps(String title, String shortDesc, List<String> ingredients) {
        String prompt = String.format("제목: %s\n설명: %s\n재료: %s\n이 정보로 구체적인 조리 단계를 나눠서 작성해줘.", 
                        title, shortDesc, String.join(", ", ingredients));
        return callGpt(prompt);
    }

    private String callGpt(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o-mini"); // 가성비 좋은 미니 모델 사용
        body.put("messages", List.of(Map.of("role", "user", "content", prompt)));

        try {
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(API_URL, entity, String.class);
            JsonNode root = mapper.readTree(response.getBody());
            return root.path("choices").get(0).path("message").path("content").asText();
        } catch (Exception e) {
            return "AI 응답을 가져올 수 없습니다.";
        }
    }
}