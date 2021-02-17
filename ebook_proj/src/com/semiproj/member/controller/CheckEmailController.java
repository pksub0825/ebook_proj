package com.semiproj.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;


public class CheckEmailController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email3 = request.getParameter("email3");
		
		System.out.println("email1="+email1+",email2="+email2+",email3="+email3);
		
		String email = "";
		
		if(email1!=null && !email1.isEmpty()){
			if(email2.equals("etc")){
				if(email3!=null && !email3.isEmpty()){
					email=email1+"@"+email3;
				}
			}else{
				email=email1+"@"+email2;
			}
		}

		System.out.println("조립된 email="+email);
		
		request.setAttribute("email", email);
		
		return "checkEmail.jsp";
	}
	
	@Override
	public boolean isRedirect() {
		return false;
	}

}
