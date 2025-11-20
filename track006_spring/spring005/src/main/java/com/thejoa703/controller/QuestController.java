package com.thejoa703.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.SboardDto;
import com.thejoa703.service.SboardService;



@Controller
public class QuestController {
	
	@Autowired SboardService service;
	
///////////////////////////////////////////////////////////
	@RequestMapping("/list.quest")
	public String list(Model model) { 
		model.addAttribute("list", service.selectAll());
		return "quest_board/list" ; }
	
///////////////////////////////////////////////////////////
	@RequestMapping("/detail.quest")
	public String detail(int id, Model model){
		model.addAttribute("dto", service.select(id));	// 처리하고
		return "quest_board/detail"; }	// 해당화면
	
///////////////////////////////////////////////////////////
	//글쓰기 폼
	@RequestMapping(value ="/write.quest",	method = RequestMethod.GET)
	public String write_get(){ return "quest_board/write"; }
	//글쓰기 기능
	@RequestMapping(value ="/write.quest",	method = RequestMethod.POST)
	public String write_post(SboardDto dto ,RedirectAttributes rttr){ 
		String result = "글쓰기 실패";
		if(service.insert(dto) > 0) {result="글쓰기 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/list.quest"; }
	
///////////////////////////////////////////////////////////
	// 수정 폼
	@RequestMapping(value ="/edit.quest",	method = RequestMethod.GET)
	public String edit_get(int id, Model model){ 
		model.addAttribute("dto",service.selectUpdateForm(id));
		return "quest_board/edit"; }
	// 수정 기능
	@RequestMapping(value ="/edit.quest",	method = RequestMethod.POST)
	public String edit_post(SboardDto dto ,RedirectAttributes rttr){ 
		String result = "비밀번호 실패";
		if(service.update(dto) > 0) {result="수정 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/detail.quest?id=" + dto.getId(); }
	//Q1. 수정기능도 실패시 알림창 + /DETAIL.QUEST
	
///////////////////////////////////////////////////////////
	// 삭제 폼
	@RequestMapping(value ="/delete.quest",	method = RequestMethod.GET)
	public String delete_get(){ return "quest_board/delete"; }
	// 삭제 기능
	@RequestMapping(value ="/delete.quest",	method = RequestMethod.POST)
	public String delete_post(SboardDto dto ,RedirectAttributes rttr){ 
		String result = "비밀번호 실패";
		if(service.delete(dto) > 0) {result="삭제 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/list.quest"; }
	//Q2. 삭제기능도 실패시 알림창 + /LIST.QUEST
	
	// 업로드 추가
	// upload
	@RequestMapping(value ="/upload.quest",	method = RequestMethod.POST)
	public String upload_post(@RequestParam("file")MultipartFile file  //그냥 파일을 던져주면 너무 크니까 이렇게 파일로 덤짐
			,SboardDto dto ,RedirectAttributes rttr){ 
		String result = "글쓰기 실패";
		if(service.insert2(file, dto) > 0) {result="글쓰기 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/list.quest"; }

	
	// 수정 업로드
	@RequestMapping(value ="/updateEdit.quest",	method = RequestMethod.POST)
	public String updateEdit_post(@RequestParam("file")MultipartFile file ,SboardDto dto ,RedirectAttributes rttr){ 
		String result = "비밀번호 실패";
		if(service.update2(file,dto) > 0) {result="수정 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/detail.quest?id=" + dto.getId(); }
}

/*
list.quest		/view/quest_board/ist.jsp		(전체보기)
insert.quest	/view/quest_board/insert.jsp	(글쓰기)
detail.quest	/view/quest_board/detail.jsp	(상세보기)
edit.quest		/view/quest_board/edit.jsp		(수정하기)
delete.quest	/view/quest_board/delete.jsp	(삭제하기)
 	
*/