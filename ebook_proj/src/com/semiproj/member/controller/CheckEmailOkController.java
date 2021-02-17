package com.semiproj.member.controller;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.member.model.MemberService;

public class CheckEmailOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String email=request.getParameter("email");
		//
		MemberService service = new MemberService();
		
		System.out.println("okcontrollemail="+email);
		if(email==null || email.isEmpty()) {
			request.setAttribute("msg", "email을 입력하세요.");
			request.setAttribute("url", "/member/checkEmail.do");
			
			return "/common/message.jsp";
		}
		int result=0;
		try {
			result=service.checkDup(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("조립된 email="+email);
		System.out.println("result="+result);
		
		if (result==service.EXIST_EMAIL) {
			request.setAttribute("msg", "이미 등록된 email입니다.");
			request.setAttribute("url", "/member/checkEmail.do");
			return "/common/message.jsp";
		}else if (result==service.NON_EXIST_EMAIL) {
			request.setAttribute("msg", "사용가능한 email입니다.사용하시겠습니까?");
			return "/common/messageClose.jsp";
		}
		
		request.setAttribute("msg", "잘못된 요청입니다");
		request.setAttribute("url", "/main.do");
		
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
