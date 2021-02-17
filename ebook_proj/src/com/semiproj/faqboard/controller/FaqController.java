package com.semiproj.faqboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class FaqController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			9. FAQ게시판 화면 보여주기
		
			/faqBoard/faqView.do => FaqController
			=> faqView.jsp로 포워드
		*/
		
		return "/faqBoard/faqView.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
