package com.semiproj.writer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class WriterInsertController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		return "/writer/writerInsert.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
	

}
