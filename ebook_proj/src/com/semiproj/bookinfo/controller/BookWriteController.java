package com.semiproj.bookinfo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class BookWriteController implements Controller{
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "/book/bookWrite.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
