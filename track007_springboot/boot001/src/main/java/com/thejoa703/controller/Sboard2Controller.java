package com.thejoa703.controller;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dao.Sboard2Dao;
import com.thejoa703.dto.Sboard2Dto;
import com.thejoa703.service.Sboard2Service;
import com.thejoa703.util.UtilPaging;



@Controller
@RequestMapping("/board")	//공통 prefix
class Sboard2Controller {
	
	@Autowired Sboard2Service service;
	@Autowired Sboard2Dao dao;
	
	
	
	//list
	/*
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="pageNo", defaultValue="1") int pageNo) {
		model.addAttribute("paging", new UtilPaging(service.selectTotalCnt(), pageNo));
		model.addAttribute("list",service.select10(pageNo));	//처리
		return "board/list";	//화면
	}
	*/
	@GetMapping("/list")
	public String list(
	        @RequestParam(defaultValue="") String keyword,
	        @RequestParam(defaultValue="1") int pageNo,
	        Model model) {

	    List<Sboard2Dto> list = service.searchList(keyword, pageNo);

	    int total = dao.countSearch(keyword);
	    UtilPaging paging = new UtilPaging(total, pageNo, 3);

	    model.addAttribute("list", list);
	    model.addAttribute("paging", paging);
	    model.addAttribute("keyword", keyword);

	    return "board/list";
	}
	
	//write (폼)
	@GetMapping("/write")
	public String write_get() {
		return "board/write";	//화면
	}
	
	//write	(기능)
	@PostMapping("/write")
	public String write_post(Sboard2Dto dto, RedirectAttributes rttr, MultipartFile file) {
		String result = "글쓰기 실패";
		if(service.insert(file, dto) > 0) {
			result ="글쓰기 성공";
		}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/list";	//화면
	}
	
	//detail
	@GetMapping("/detail")
	public String detail(int id, Model model) {
		model.addAttribute("dto",service.select(id));	//처리
		return "board/detail";	//화면
	}
	
	//edit	(폼)
	@GetMapping("/edit")
	public String edit_get(int id, Model model) {
		model.addAttribute("dto",service.selectUpdateForm(id));
		return "board/edit";	//화면
	}
	
	//edit	(기능)
	@PostMapping("/edit")
	public String edit_post(Sboard2Dto dto, RedirectAttributes rttr, MultipartFile file) {
		String result = "글수정 실패";
		if(service.update(file, dto) > 0) {
			result ="글수정 성공";
		}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/detail?id=" + dto.getId();

	}
	
	//delete	(폼)
	@GetMapping("/delete")
	public String delete_get() {
		return "board/delete";	//화면
	}
	
	//delete	(기능)
	@PostMapping("/delete")
	public String delete_post(Sboard2Dto dto, RedirectAttributes rttr, MultipartFile file) {
		String result = "글삭제 실패";
		if(service.delete(dto) > 0) {
			result ="글삭제 성공";
		}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/list";	//화면
	}
	
	
}
