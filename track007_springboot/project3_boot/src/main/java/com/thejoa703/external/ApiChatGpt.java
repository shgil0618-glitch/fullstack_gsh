package com.thejoa703.external;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders; //##
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiChatGpt {

	@Value("${openai.api.key}")
	private String apiKey;
	
	private static final String API_URL="https://api.openai.com/v1/chat/completions";
	private final ObjectMapper objectMapper=new ObjectMapper();
	
	// 이 일기를 이모티콘으로 요약해줘
	public String getAIResponse(String userMessage) {
		RestTemplate  restTemplate = new RestTemplate();
	    //org.springframework.http.HttpHeaders;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + apiKey);  //## 공백주의
		
		Map<String, Object> body = new HashMap<>();
		body.put("model", "gpt-4.1-nano");
		body.put("messages", List.of(
				Map.of("role" , "user" , "content" , userMessage + "이 일기를 이모티콘으로 요약해줘")
		)); 
	    //org.springframework.http.HttpEntity;
		HttpEntity<Map<String, Object>>  requestEntity = new HttpEntity<>(body, headers);
		/////////////////////////////////////////////////////////////////////////////////

	    //org.springframework.http.ResponseEntity                          주소,      요청,          응답형태
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(API_URL, requestEntity, String.class);
		String responseBody = responseEntity.getBody();
		
		//com.fasterxml.jackson.databind.JsonNode
		try {
			JsonNode root =   objectMapper.readTree(responseBody);  
			return  root.path("choices").get(0).path("message").path("content").asText();
		} catch (Exception e) { throw new RuntimeException("OpenAI 응답 파싱 오류" , e); }
		 
	}
}


/*
package com.thejoa703.external;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




@Service
public class ApiChatGpt {

	@Value("${openai.api.key}")
	private String apikey;
	
	private static final String API_URL="https://api.openai.com/v1/chat/completions";
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	// 이 내용을 이모티콘으로 요약해줘
	public String getAIResponse(String userMessage) {
		RestTemplate restTenplate = new RestTemplate();
		//
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + apikey);	//Bearer 뒤에 공백 하나 있어야함
		
		Map<String,Object> body = new HashMap<>();
		body.put("model","gpt-4.1-mini");
		body.put("messages",List.of(
				Map.of("role", "user", "content", userMessage + "이 일기를 이모티콘으로 요약해줘")
				));
		
		HttpEntity<Map<String,Object>> requestEntity = new HttpEntity<>(body,headers);
		//////////////////////////////////////////////////////////////////////////////////////////
		//																	주소		요청				응답형태
		ResponseEntity<String> responseEntity = restTenplate.postForEntity(API_URL, requestEntity, String.class);
		
		String responseBody = responseEntity.getBody();
		try {
			JsonNode root = objectMapper.readTree(responseBody);
			return root.path("choices").get(0).path("message").path(0).asText();
		} catch (Exception e) {
			throw new RuntimeException("OpenAI 응답 파싱 오류",e);
		}

	}
}
*/