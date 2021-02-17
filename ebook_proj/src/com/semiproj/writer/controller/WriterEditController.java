package com.semiproj.writer.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.writer.model.WriterService;
import com.semiproj.writer.model.WriterVO;

public class WriterEditController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String no=request.getParameter("no");
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다.");
			request.setAttribute("url", "/writer/writerList.do");
			
			return "/common/message.jsp";
		}
		
		WriterService service=new WriterService();
		WriterVO vo=null;
		
		try {
			vo=service.selectByNo(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("vo", vo);
		
		return "/writer/writerEdit.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	

}
