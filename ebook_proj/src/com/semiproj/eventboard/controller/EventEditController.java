package com.semiproj.eventboard.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.eventboard.model.eventBoardService;
import com.semiproj.eventboard.model.eventBoardVO;

public class EventEditController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 5. 글 수정화면 보여주기
		
		/eventBoard/eventEdit.do => EventEditController
		=> eventEdit.jsp로 포워드
		*/
		//1
		//=> http://localhost:9090/semiproj/eventBoard/eventEdit.do?no=9
		String no=request.getParameter("no");
		System.out.println();
		
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다.");
			request.setAttribute("url", "/eventBoard/eventDetail.do");
			
			return "/common/message.jsp";
		}
		
		//2
		eventBoardService eventService=new eventBoardService();
		eventBoardVO eventVo=null;
		
		try {
			eventVo = eventService.selectByNo(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//3
		request.setAttribute("eventVo", eventVo);
		
		//4
		return "/eventBoard/eventEdit.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
