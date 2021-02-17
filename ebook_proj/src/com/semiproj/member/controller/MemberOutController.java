package com.semiproj.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.member.model.MemberVO;

public class MemberOutController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "memberOut.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
