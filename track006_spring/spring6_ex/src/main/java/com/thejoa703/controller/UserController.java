package com.thejoa703.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    // 회원가입 폼
    @RequestMapping(value="/signup.user", method=RequestMethod.GET)
    public String signup_get() {
        return "join"; // UserJoin.jsp
    }

    // 회원가입 기능
    @RequestMapping(value="/signup.user", method=RequestMethod.POST)
    public String signup_post(UserDto dto, RedirectAttributes rttr) {
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
    public String login_get() {
        return "user/UserLogin"; // UserLogin.jsp
    }

    // 로그인 기능
    @RequestMapping(value="/login.user", method=RequestMethod.POST)
    public String login_post(UserDto dto, HttpSession session, RedirectAttributes rttr) {
        UserDto loginUser = service.login(dto);

        if(loginUser == null) {
            rttr.addFlashAttribute("error","아이디 또는 비밀번호가 틀립니다.");
            return "redirect:/login.user";
        }

        session.setAttribute("loginUser", loginUser);
        return "redirect:/mypage.user";
    }

    ///////////////////////////////////////////////////////////
    // 마이페이지
    @RequestMapping("/mypage.user")
    public String mypage(HttpSession session, Model model) {
        UserDto loginUser = (UserDto)session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login.user";

        model.addAttribute("dto", service.select(loginUser.getAppUserId()));
        return "user/MyPage"; // MyPage.jsp
    }

    ///////////////////////////////////////////////////////////
    // 회원정보 수정 폼
    @RequestMapping(value="/edit.user", method=RequestMethod.GET)
    public String edit_get(HttpSession session, Model model) {
        UserDto loginUser = (UserDto)session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login.user";

        model.addAttribute("dto", service.select(loginUser.getAppUserId()));
        return "user/UserEdit"; // UserEdit.jsp
    }

    // 회원정보 수정 기능
    @RequestMapping(value="/edit.user", method=RequestMethod.POST)
    public String edit_post(UserDto dto, RedirectAttributes rttr) {
        String msg = "정보수정 실패";
        if(service.update(dto) > 0) msg = "정보수정 성공";

        rttr.addFlashAttribute("success", msg);
        return "redirect:/mypage.user";
    }

    ///////////////////////////////////////////////////////////
    // 로그아웃
    @RequestMapping("/logout.user")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main.user";
    }

    ///////////////////////////////////////////////////////////
    // 회원 탈퇴 폼
    @RequestMapping(value="/delete.user", method=RequestMethod.GET)
    public String delete_get() {
        return "UserDelete"; // UserDelete.jsp
    }

    // 회원 탈퇴 기능
    @RequestMapping(value="/delete.user", method=RequestMethod.POST)
    public String delete_post(UserDto dto, HttpSession session, RedirectAttributes rttr) {
        String msg = "비밀번호가 일치하지 않습니다.";

        if(service.delete(dto) > 0) {
            msg = "회원탈퇴 성공";
            session.invalidate();
            return "redirect:/main.user";
        }

        rttr.addFlashAttribute("success", msg);
        return "redirect:/mypage.user";
    }
}
