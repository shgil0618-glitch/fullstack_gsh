package com.thejoa703.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Service
public class NaverBookXmlService {
		
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class channel{
		@JacksonXmlProperty(localName = "item")	//태그
		@JacksonXmlElementWrapper(useWrapping = false)	// items들을 묶어서 wrapper태그없이 
		private List<BookDto> items;

		public List<BookDto> getItems() { return items; }
		public void setItems(List<BookDto> items) { this.items = items; }
	}
		@JsonIgnoreProperties(ignoreUnknown = true)
		static class Rss{
			@JacksonXmlProperty(localName="channel")
			private Channel channel;
			public Channel getChannel() {return channel;}
			public void setChannel(Channel channel) {this.channel=channel;}
		}
	
		public List<BookDto> getBook(String query) throws UnsupportedEncodingException{
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper objectMapper = new ObjectMapper();
			
			String clientId="네이버 클라이언트 아이디";
			String clientSecret="네이버 개인 키";
			String param ="?query=" + URLEncoder.encode(query,"UTF-8");
			String url="https://openapi.naver.com/v1/search/book.xml" + param;
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Naver-Client-Id", clientId);
			headers.set("X-Naver-Client-Secret", url);
			headers.set("Accept","application/xml");
			
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
