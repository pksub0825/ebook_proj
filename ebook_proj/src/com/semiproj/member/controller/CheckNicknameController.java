package com.semiproj.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class CheckNicknameController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String nickname = request.getParameter("nickname");
		
		System.out.println("받아온 nickname="+nickname);
		
		request.setAttribute("nickname", nickname);

		return "checkNickname.jsp";
	}

	@Override
	public boolean isRedirect() {
		
		return false;
	}

}
