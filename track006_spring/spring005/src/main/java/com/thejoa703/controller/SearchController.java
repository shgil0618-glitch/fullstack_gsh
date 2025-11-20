package com.thejoa703.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.SboardDto;
import com.thejoa703.service.SboardService;

@RestController		// @Controller+@ResponseBody
public class SearchController {

	@Autowired SboardService service;
	
	@RequestMapping("/searchTest")
	@ResponseBody
	public String hi() {
		//처리하고
		return "hi";	//값줄게
	}
	
	@RequestMapping("/selectSearch")
	public List<SboardDto> selectSearch(@RequestParam("search") String search){
		return service.selectSearch(search);
	}
	
}





/*@Controller
public class SearchController {

	@Autowired SboardService service;
	
	@RequestMapping("/searchTest")
	@ResponseBody
	public String hi() {
		//처리하고
		return "hi";	//값줄게
	}
}*/
