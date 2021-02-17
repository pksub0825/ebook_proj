package com.semiproj.bookinfo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;

public class ReadCountController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		String no=request.getParameter("no");
		
		//2.
		BookInfoService service=new BookInfoService();
		try {
			int cnt=service.updateReadCount(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "/book/bookDetail.do?no="+no;
	}

	@Override
	public boolean isRedirect() {
		return true;
	}
}
