package com.thejoa703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thejoa703.service.Sboard2Service;
import com.thejoa703.util.UtilPaging;

@Controller
public class MainController {

		@Autowired private Sboard2Service service;
		
		@GetMapping("/")
		public String list(Model model, @RequestParam(value="pageNo", defaultValue = "1") int pageNo) {
			model.addAttribute("paging", new UtilPaging(service.selectTotalCnt(),pageNo));
			model.addAttribute("list",service.select10(pageNo));
			model.addAttribute("imglist",service.select10(pageNo));
			
			//return "redirect:/index";	//static/index.html (정적페이지 - 미리올라가있는 데이터)
			return "index";				//templates/index	(동적페이지 - 서비스와 관련되 내용들)
		}

}
