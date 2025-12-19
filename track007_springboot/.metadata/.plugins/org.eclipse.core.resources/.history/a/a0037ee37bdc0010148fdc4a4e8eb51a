package com.thejoa703.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thejoa703.external.ApiChatGpt;
import com.thejoa703.external.ApiKmaWeather;

@Controller
@RequestMapping("/api")
public class ApiController {

	///////////////////////// ChatGpt
	@Autowired
	ApiChatGpt apiChatGpt;

	@GetMapping("/openai")
	public String openai_get() {
		return "external/openai";
	}

	@PostMapping(value = "/openai", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String openai(@RequestBody String content) {
		return apiChatGpt.getAIResponse(content);
	}

///////////////////////// Weather
	@Autowired
	ApiKmaWeather apiKmaWeather;

	@GetMapping("/weather")
	public String kma_get() {
		return "external/weather";
	}

	@GetMapping(value = "/weatherapi", produces = "application/xml; charset=UTF-8")
	@ResponseBody
	public String kma() throws URISyntaxException {
		return apiKmaWeather.getWeatherResponse();
	}

}
