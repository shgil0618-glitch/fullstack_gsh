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
}
