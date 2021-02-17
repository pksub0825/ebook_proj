package com.semiproj.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "login.jsp";
	}

	@Override
	public boolean isRedirect() {
		
		return false;
	}

}
