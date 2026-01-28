package com.thejoa703.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OpenAIEmbeddingService {
    @Value("${openai.api.key}")
    private String apiKey;
    private static final String API_URL = "https://api.openai.com/v1/embeddings";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String recommendKeyword(String input, List<String> candidates) {
        double[] inputVec = getEmbedding(input);
        String bestMatch = null;
        double bestScore = -1.0;

        for (String candidate : candidates) {
            double[] candidateVec = getEmbedding(candidate);
            double score = cosineSimilarity(inputVec, candidateVec);
            if (score > bestScore) {
                bestScore = score;
                bestMatch = candidate;
            }
        }
        return bestMatch;
    }

    private double[] getEmbedding(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of("model", "text-embedding-3-small", "input", text);
        try {
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
            String response = restTemplate.postForObject(API_URL, entity, String.class);
            JsonNode vectorNode = objectMapper.readTree(response).get("data").get(0).get("embedding");
            double[] vector = new double[vectorNode.size()];
            for (int i = 0; i < vectorNode.size(); i++) vector[i] = vectorNode.get(i).asDouble();
            return vector;
        } catch (Exception e) {
            throw new RuntimeException("Embedding 생성 실패", e);
        }
    }

    private double cosineSimilarity(double[] v1, double[] v2) {
        double dot = 0, n1 = 0, n2 = 0;
        for (int i = 0; i < v1.length; i++) {
            dot += v1[i] * v2[i];
            n1 += v1[i] * v1[i];
            n2 += v2[i] * v2[i];
        }
        return dot / (Math.sqrt(n1) * Math.sqrt(n2));
    }
}