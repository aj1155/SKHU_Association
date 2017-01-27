package me.skhu.config.securityHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SecuritySuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authenticaiotn) throws IOException, ServletException{
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("login success");
		response.sendRedirect("board/list");
	}
}
