package com.thejoa703.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.UserDto;
import com.thejoa703.service.UserService;

@Controller
public class UserController {

    @Autowired 
    UserService service;

    ///////////////////////////////////////////////////////////
    // 회원 목록 페이지
    @RequestMapping("/list.user")
    public String listuser(Model model) {
        model.addAttribute("List", service.selectAll()); 
        return "member/list"; 
    }

    ///////////////////////////////////////////////////////////
    // 회원가입 폼
    @RequestMapping(value="/join.user", method=RequestMethod.GET)
    public String joinPage() {
        return "member/join"; 
    }

    // 회원가입 기능
    @RequestMapping(value="/join.user", method=RequestMethod.POST)
    public String joinUser(UserDto dto, RedirectAttributes rttr) {
        String msg = "회원가입 실패";
        if(service.insert(dto) > 0) {
            msg = "회원가입 성공";
        }
        rttr.addFlashAttribute("success", msg);
        return "redirect:/login.user"; 
    }

    ///////////////////////////////////////////////////////////
    // 로그인 폼
    @RequestMapping(value="/login.user", method=RequestMethod.GET)
    public String loginPage() {
        return "member/login"; 
    }

	/*
	 * // 로그인 기능
	 * 
	 * @RequestMapping(value="/login.user", method=RequestMethod.POST) public String
	 * loginUser(UserDto dto, HttpSession session, RedirectAttributes rttr) {
	 * UserDto loginUser = service.login(dto);
	 * 
	 * if(loginUser == null) { rttr.addFlashAttribute("error",
	 * "아이디 또는 비밀번호가 틀립니다."); return "redirect:/login.user"; }
	 * 
	 * session.setAttribute("loginUser", loginUser); return "redirect:/mypage.user";
	 * }
	 */
    
 // 로그인 기능
    @RequestMapping(value="/login.user", method=RequestMethod.POST)
    public String loginUser(UserDto dto, HttpSession session, RedirectAttributes rttr) {
        // service.login() 메서드가 실제로 아이디와 비밀번호를 검증하고 유효한 사용자 정보를 반환하는지 확인
        UserDto loginUser = service.login(dto);

        if(loginUser == null) {
            rttr.addFlashAttribute("error", "아이디 또는 비밀번호가 틀립니다.");
            return "redirect:/login.user"; // 로그인 페이지로 리디렉션
        }

        // 로그인 성공 시 세션에 로그인한 사용자 정보를 저장
        session.setAttribute("loginUser", loginUser);

        // 마이페이지로 리디렉션
        return "redirect:/mypage.user"; 
    }


    ///////////////////////////////////////////////////////////
    // 마이페이지
    @RequestMapping("/mypage.user")
    public String myPage(HttpSession session, Model model) {
        UserDto loginUser = (UserDto)session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login.user"; 

        model.addAttribute("dto", service.select(loginUser.getAppUserId()));
        return "member/mypage"; 
    }

    ///////////////////////////////////////////////////////////
    // 회원정보 수정 폼
    @RequestMapping(value="/edit.user", method=RequestMethod.GET)
    public String editPage(HttpSession session, Model model) {
        UserDto loginUser = (UserDto)session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login.user";

        model.addAttribute("dto", service.select(loginUser.getAppUserId()));
        return "member/edit"; 
    }

    // 회원정보 수정 기능
    @RequestMapping(value="/edit.user", method=RequestMethod.POST)
    public String editUser(UserDto dto, RedirectAttributes rttr) {
        String msg = "정보수정 실패";
        if(service.update(dto) > 0) msg = "정보수정 성공";

        rttr.addFlashAttribute("success", msg);
        return "redirect:/mypage.user"; 
    }

    ///////////////////////////////////////////////////////////
	/*
	 * // 회원 탈퇴 기능
	 * 
	 * @RequestMapping(value="/delete.user", method=RequestMethod.GET) public String
	 * deletePage() { return "member/delete"; }
	 * 
	 * // 회원 탈퇴 후 리디렉션
	 * 
	 * @RequestMapping(value="/delete.user", method=RequestMethod.POST) public
	 * String deleteUser(UserDto dto, HttpSession session, RedirectAttributes rttr)
	 * { String msg = "비밀번호가 일치하지 않습니다.";
	 * 
	 * if(service.delete(dto) > 0) { msg = "회원탈퇴 성공"; session.invalidate(); return
	 * "redirect:/list.user"; }
	 * 
	 * rttr.addFlashAttribute("error", msg); return "redirect:/mypage.user"; }
	 */
    @RequestMapping(value="/delete.user", method=RequestMethod.POST)
    public String deleteUser(UserDto dto, HttpSession session, RedirectAttributes rttr) {
        String msg = "비밀번호가 일치하지 않습니다."; // 기본 메시지

        // service.delete(dto) 호출하기 전에 비밀번호 확인을 해야 합니다.
        UserDto user = service.select(dto.getAppUserId()); // appUserId로 사용자 정보 가져오기

        if (user != null && user.getPassword().equals(dto.getPassword())) {
            // 비밀번호가 맞으면 삭제 진행
            if (service.delete(dto) > 0) {
                msg = "회원탈퇴 성공";
                session.invalidate(); // 탈퇴 후 세션 종료
                return "redirect:/list.user"; // 목록 페이지로 리디렉션
            }
        }

        rttr.addFlashAttribute("error", msg); // 비밀번호가 일치하지 않거나 삭제 실패 시 오류 메시지
        return "redirect:/list.user"; // 실패 시 마이페이지로 리디렉션
    }


    ///////////////////////////////////////////////////////////
    // 로그아웃
    @RequestMapping("/logout.user")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 종료
        return "redirect:/main.user"; // 메인 페이지로 리디렉션
    }
}
