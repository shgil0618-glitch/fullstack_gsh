package com.thejoa703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security/*")
public class SecurityController {
	
	@RequestMapping("/all")
	public String all() {
		return "member/all";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member/member";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "member/admin";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("/fail")
	public String fail() {
		return "member/fail";	//알림창
	}
	
}
