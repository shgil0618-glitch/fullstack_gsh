package com.thejoa703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private AppUserService userService;
	
	/* 회원가입 */	
	//http://localhost:8484/boot001/users/iddouble?email=1@1&provider=local
	@PreAuthorize("permitAll()")
	@RequestMapping("/iddouble")
	@ResponseBody
	public Map<String, Object>  iddouble( @RequestParam String email, @RequestParam String provider ){
		Map<String, Object>  result = new HashMap<>();
		result.put("cnt", userService.iddouble(email, provider));
		return result;
	} 
	//http://localhost:8484/boot001/users/join
	@GetMapping("/join")
	public String joinForm() {  return "users/join"; }
	
	@PostMapping("/join")
	public String join( @RequestParam(value="file" , required=false) MultipartFile file
		, AppUserDto dto , RedirectAttributes rttr ) {
		  try {	
			int result = userService.insert(file, dto);
			rttr.addFlashAttribute("successMessage" , result > 0? "회원가입 성공!" : "회원가입 실패");
			return "redirect:/users/login";
		  }catch(Exception e) { 
				rttr.addFlashAttribute("errorMessage" ,  "회원가입 실패: " +  e.getMessage());
				return "redirect:/users/join";
		  }
	}
	

	/* 로그인 : 폼 , 성공, 실패 */
	@GetMapping("/login")
	public String loginForm() { return "users/login"; }
	
	@GetMapping("/fail")
	public String loginFail(Model model) {
		model.addAttribute("errorMessage" , "로그인 실패: 아이디 또는 비밀번호를 확인하세요.");
		return "users/login";
	}
	
	/* 마이페이지 */	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage")
	public String mypage() { return "users/mypage"; }

	/* 회원정보수정 폼, 기능 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/update")
	public String updateForm() { return "users/update"; }
	

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/update")
	public String update() { return "users/mypage"; }

	/* 회원탈퇴 폼, 기능 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete")
	public String deleteForm() { return "users/delete"; }
	

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/delete")
	public String delete() { return "users/login"; }

}

