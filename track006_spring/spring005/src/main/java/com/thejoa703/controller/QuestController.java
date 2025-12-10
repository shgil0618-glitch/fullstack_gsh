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
		model.addAttribute("dto", service.select(id));	
		return "quest_board/detail"; }	
	
///////////////////////////////////////////////////////////
	//글쓰기 폼
	@RequestMapping(value ="/write.quest",	method = RequestMethod.GET)
	public String write_get(){ return "quest_board/write"; }
	//글쓰기 기능
	@RequestMapping(value ="/write.quest",	method = RequestMethod.POST)
	public String write_post(SboardDto dto ,RedirectAttributes rttr){ 
		String result = "작성 실패";
		if(service.insert(dto) > 0) {result="작성 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/list.quest"; }
	
///////////////////////////////////////////////////////////
	// 글수정 폼
	@RequestMapping(value ="/edit.quest",	method = RequestMethod.GET)
	public String edit_get(int id, Model model){ 
		model.addAttribute("dto",service.selectUpdateForm(id));
		return "quest_board/edit"; }
	// 글수정 기능
	@RequestMapping(value ="/edit.quest",	method = RequestMethod.POST)
	public String edit_post(SboardDto dto ,RedirectAttributes rttr){ 
		String result = "비밀번호 오류";
		if(service.update(dto) > 0) {result="수정 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/detail.quest?id=" + dto.getId(); }
	//Q1. ������ɵ� ���н� �˸�â + /DETAIL.QUEST
	
///////////////////////////////////////////////////////////
	// 글삭제 폼
	@RequestMapping(value ="/delete.quest",	method = RequestMethod.GET)
	public String delete_get(){ return "quest_board/delete"; }
	// 글삭제 기능
	@RequestMapping(value ="/delete.quest",	method = RequestMethod.POST)
	public String delete_post(SboardDto dto ,RedirectAttributes rttr){ 
		String result = "비밀번호 오류";
		if(service.delete(dto) > 0) {result="삭제 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/list.quest"; }
	//Q2. ������ɵ� ���н� �˸�â + /LIST.QUEST
	
	// ���ε� �߰�
	// upload
	@RequestMapping(value ="/upload.quest",	method = RequestMethod.POST)
	public String upload_post(@RequestParam("file")MultipartFile file  //�׳� ������ �����ָ� �ʹ� ũ�ϱ� �̷��� ���Ϸ� ����
			,SboardDto dto ,RedirectAttributes rttr){ 
		String result = "작성 실패";
		if(service.insert2(file, dto) > 0) {result="작성 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/list.quest"; }

	
	// ���� ���ε�
	@RequestMapping(value ="/updateEdit.quest",	method = RequestMethod.POST)
	public String updateEdit_post(@RequestParam("file")MultipartFile file ,SboardDto dto ,RedirectAttributes rttr){ 
		String result = "비밀번호 오류";
		if(service.update2(file,dto) > 0) {result="수정 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/detail.quest?id=" + dto.getId(); }
}

/*
list.quest		/view/quest_board/ist.jsp		(��ü����)
insert.quest	/view/quest_board/insert.jsp	(�۾���)
detail.quest	/view/quest_board/detail.jsp	(�󼼺���)
edit.quest		/view/quest_board/edit.jsp		(�����ϱ�)
delete.quest	/view/quest_board/delete.jsp	(�����ϱ�)
 	
*/