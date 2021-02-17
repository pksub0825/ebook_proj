package com.semiproj.comments.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.comments.model.CommentsService;
import com.semiproj.comments.model.CommentsVO;

public class CmtListController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 	/comments/comments_List.do => CmtListController
		 	  => /comments_List.jsp로 포워드
		 	  /comments/comments_List.do=com.semiproj.comments.controller.CmtListController

		 */
		
		String no=request.getParameter("no");
		String bookNo=request.getParameter("bookNo");
		
		System.out.println("ListController no="+no+" , bookNo="+bookNo);
		// 댓글 리스트 추가
				CommentsService commService=new CommentsService();
				List<CommentsVO> list=null;
				try {
					list=commService.selectAllCmt(Integer.parseInt(no));
				}catch(SQLException e){
					e.printStackTrace();
				}
				System.out.println("listsize="+list.size());
				
				request.setAttribute("commList", list);
				
				return "/comments_List.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
