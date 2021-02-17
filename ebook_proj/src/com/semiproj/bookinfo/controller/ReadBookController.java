package com.semiproj.bookinfo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;

public class ReadBookController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String no=request.getParameter("no");
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url");
			request.setAttribute("url", "/book/bookList.do");
			
			return "/common/message.jsp";
		}
		
		String page=request.getParameter("page");
		if(page==null || page.isEmpty()) page="1";
		
		BookInfoService service=new BookInfoService();
		BookInfoVO vo=null;
		try {
			vo=service.selectByNo(Integer.parseInt(no));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bookVo", vo);
		request.setAttribute("page", page);
		
		return "/book/readBook.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
