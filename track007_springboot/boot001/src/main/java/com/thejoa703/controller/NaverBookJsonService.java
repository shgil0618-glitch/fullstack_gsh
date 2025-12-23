package com.thejoa703.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NaverBookJsonService {

		public List<BookDto> getBook(String query) throws UnsupportedEncodingException{
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper objectMapper = new ObjectMapper();
			
			String clientId="네이버 클라이언트 아이디";
			String clientSecret="네이버 개인 키";
			String param ="?query=" + URLEncoder.encode(query,"UTF-8");
			String url="https://openapi.naver.com/v1/search/book.json" + param;
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Naver-Client-Id", clientId);
			headers.set("X-Naver-Client-Secret", url);
			
			HttpEntity<String> entity = new HttpEntity<>(null, headers);
			
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
			///////////////////////////////////////////////////////////////////////////
			List<BookDto> result = new ArrayList<>();
			try {
				JsonNode root = objectMapper.readTree(response.getBody());
				System.out.println("......." + root);
				for(JsonNode item : root.path("items")) {
					BookDto book = new BookDto();
					book.setTitle(item.path("title").asText());
					book.setImage(item.path("image").asText());
					book.setAuthor(item.path("author").asText());
					result.add(book);
				}
			} catch (Exception e) {
				e.printStackTrace();}
			return result;
		} 
	
}
