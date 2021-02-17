package com.semiproj.comments.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.comments.model.CommentsService;
import com.semiproj.comments.model.CommentsVO;

public class CmtEditController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	/*
	 * 	/comments/comments_edit.do => CmtEditController
	 * ==>comments.jsp로 포워드
	 */
		String no=request.getParameter("no");
		
		System.out.println("Controller no="+no);
		
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다.");
			request.setAttribute("url", "comments/comments_detail.do");
			
			return "/common/message.jsp";
		}
		
		CommentsVO commVo=new CommentsVO();
		CommentsService cmtservice=new CommentsService();
		List<CommentsVO> list=null;
		
		try {
			list=cmtservice.selectAllCmt(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("commList", list);
		
		return "/comments/comments_edit.jsp";
	}
	@Override
	public boolean isRedirect() {
		return false;
	}

}
