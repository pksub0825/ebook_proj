package com.semiproj.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.getSession().invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("url", "/main.do");
		
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
