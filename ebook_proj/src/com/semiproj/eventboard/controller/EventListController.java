package com.semiproj.eventboard.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.common.PagingVO;
import com.semiproj.eventboard.model.eventBoardService;
import com.semiproj.eventboard.model.eventBoardVO;
import com.semiproj.member.model.MemberVO;

public class EventListController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			3. 게시판 글목록 보여주기
			
			/eventBoard/eventList.do => EventListController
			=> eventList.jsp로 포워드 
		*/
		//1. 요청 파라미터 읽어오기
		String condition=request.getParameter("searchCondition");
		String keyword=request.getParameter("searchKeyword");
		
		//세션 닉네임
		MemberVO memVo=(MemberVO)request.getSession().getAttribute("memVo");
		String nickname="";
		if(memVo!=null) nickname=memVo.getNickname();
		
		//2. 비즈니스 로직 처리 - 모델에 의뢰, db 작업
		eventBoardService eventService=new eventBoardService();
		List<eventBoardVO> eventList=null;
		
		try {
			eventList=eventService.selectAll(condition, keyword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//페이징 처리
		int currentPage=1;
		if(request.getParameter("currentPage")!=null
				&& !request.getParameter("currentPage").isEmpty()) {
			currentPage
				=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalRecord=0;
		if(eventList!=null) totalRecord=eventList.size();
		
		int pageSize=5;
		int blockSize=10;
		
		PagingVO pageVo=new PagingVO(currentPage, totalRecord, pageSize, blockSize);
		
		//3. request에 결과 저장
		request.setAttribute("eventList", eventList);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("nickname", nickname);
		
		//4. 뷰페이지 리턴
		return "/eventBoard/eventList.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
