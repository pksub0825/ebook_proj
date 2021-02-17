package com.semiproj.eventboard.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.eventboard.model.eventBoardService;
import com.semiproj.eventboard.model.eventBoardVO;
import com.semiproj.member.model.MemberVO;

public class EventDetailController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			4. 글 상세보기 
		
			/eventBoard/eventDetail.do => EventDetailController
			=> eventDetail.jsp로 포워드 
		*/
		//1. 요청 파라미터 읽어오기
		//=> http://localhost:9090/semiproj/eventBoard/eventDetail.do?no=6
		String no=request.getParameter("no");
		System.out.println("no="+no);
		
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다.");
			request.setAttribute("url", "/eventBoard/eventList.do");
			
			return "/common/message.jsp";
		}
		
		//세션 닉네임(관리자확인용)
		MemberVO memVo=(MemberVO)request.getSession().getAttribute("memVo");
		String nickname="";
		if(memVo!=null) nickname=memVo.getNickname();
		
		//2. 비즈니스 로직 처리 - 모델에 의뢰, db작업
		eventBoardService eventService=new eventBoardService();
		eventBoardVO eventVo=null;
		List<eventBoardVO> eList=null;
		
		try {
			eventVo=eventService.selectByNo(Integer.parseInt(no));
			eList=eventService.listSideMenu();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//3. request에 결과 저장
		request.setAttribute("eventVo", eventVo);
		request.setAttribute("eList", eList);
		request.setAttribute("nickname", nickname);
		
		//4. 뷰페이지 리턴
		return "/eventBoard/eventDetail.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
