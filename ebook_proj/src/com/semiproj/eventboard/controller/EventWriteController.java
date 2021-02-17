package com.semiproj.eventboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class EventWriteController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			1. 게시판 글쓰기 화면 보여주기 eventWrite.jsp
			
			/eventBoard/eventWrite.do => EventWriteController
			=> eventWrite.jsp로 포워드 
		*/
		//1	
		//2		
		//3		
		//4		
		return "eventWrite.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
