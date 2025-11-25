package com.thejoa703.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class loginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//## 인가(접근, 허용)
		List<String> roles = new ArrayList<>();	//권한 리스트에 추가
		//				권한들
		authentication.getAuthorities().forEach(auth-> {
			roles.add(auth.getAuthority());
		});
//		if(roles.contains("ROLE_ADMIN")) {response.sendRedirect("security/admin"); return;}
//		if(roles.contains("ROLE_MEMBER")) {response.sendRedirect("security/member"); return;}
		if(roles.contains("ROLE_ADMIN")) {response.sendRedirect(request.getContextPath() + "/security/admin"); return;}
		if(roles.contains("ROLE_MEMBER")) {response.sendRedirect(request.getContextPath() + "/security/member"); return;}
		response.sendRedirect("/");
	}
}
