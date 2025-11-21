package com.thejoa703.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thejoa703.dto.UserDto;
import com.thejoa703.service.UserService;

@RestController
public class AdminAjaxController {

    @Autowired 
    UserService service;

    @RequestMapping("/selectAll")
    public List<UserDto> selectAll(){
        return service.selectAll();
    }
    
    @RequestMapping("/select")
    public Map<String,Object> select(@RequestParam int appUserId){
    	Map<String,Object> result = new HashMap<>();
    	result.put("result", service.select(appUserId));
    	return result;
    }
    // http://localhost:8282/ex006_member/updateAdmin?appUserId=68&mbtiTypeId=2
    @RequestMapping("/updateAdmin")
    public Map<String,Object> updateAdmin(@RequestParam int appUserId, @RequestParam int mbtiTypeId){
    	Map<String,Object> result = new HashMap<>();
    	UserDto dto = new UserDto();
    	dto.setAppUserId(appUserId); dto.setMbtiTypeId(mbtiTypeId);
    	result.put("result", service.updateAdmin(dto));
    	return result;
    }
    
    // http://localhost:8282/ex006_member/deleteAdmin?appUserId=68 
    @RequestMapping("/deleteAdmin")
    public Map<String,Object> deleteAdmin(@RequestParam int appUserId){
    	Map<String,Object> result = new HashMap<>();
    	UserDto dto = new UserDto();
    	dto.setAppUserId(appUserId); 
    	result.put("result", service.deleteAdmin(dto));
    	return result;
    }
    
	/*
	 * @RequestMapping("/adminEdit") public Map<String, Object>
	 * adminEdit(@RequestParam int appUserId) { Map<String,Object> result = new
	 * HashMap<>(); result.put("sresult", service.select(appUserId)); return result;
	 * }
	 * 
	 * @RequestMapping("/adminDelete") public Map<String, Object>
	 * adminDelete(@RequestParam int appUserId) { Map<String,Object> result = new
	 * HashMap<>(); result.put("result", service.select(appUserId)); return result;
	 * }
	 */
    
}
