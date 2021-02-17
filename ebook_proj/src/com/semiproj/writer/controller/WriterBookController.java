package com.semiproj.writer.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;

public class WriterBookController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String wrno=request.getParameter("wrno");
		
		if(wrno==null || wrno.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다");
			request.setAttribute("url", "/board/list.do");
			
			return "/common/message.jsp";
			
		}
		
		BookInfoService service=new BookInfoService();
		BookInfoVO vo=null;
		List<BookInfoVO> list=null;
		try {
			list=service.selectByWrno(Integer.parseInt(wrno));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		return "/writer/writerBook.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
