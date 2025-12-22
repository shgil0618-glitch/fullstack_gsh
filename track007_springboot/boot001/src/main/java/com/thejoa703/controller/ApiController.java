package com.thejoa703.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thejoa703.external.ApiChatGpt;
import com.thejoa703.external.ApiEmailNaver;
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

////////////////////////////////////////////Email
	@Autowired
	ApiEmailNaver apiEmailNaver;

	@GetMapping("/mail")
	public String mail_get() {
		return "external/mail";
	}

	@PostMapping(value = "/mail")
	public String mail(String subject, String content, String email) {
		apiEmailNaver.sendMail(subject, content, email);
		return "external/mail_result";
	}
	
////////////////////////////////////////////CoolSMS
	/*
	 * @Autowired ApiCoolSms apiCoolSms;
	 * 
	 * @GetMapping("/sms") public String sms() {return "external/sms";}
	 * 
	 * @GetMapping("/smsapi")
	 * 
	 * @ResponseBody public String sms_api(@RequestParam String to) throws
	 * CoolsmsException { return apiCoolSms.phoneNumber(to); }
	 */

//////////////////////////////////////////// PostCode
	
	@GetMapping("/postcode")
	public String postcode() {return "external/postcode";}
	
//////////////////////////////////////////// navermaps
	
	@GetMapping("/maps")
	public String maps() {return "external/navermap";}
	
	
}
