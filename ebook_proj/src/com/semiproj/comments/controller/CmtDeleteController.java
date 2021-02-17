package com.semiproj.comments.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.comments.model.CommentsService;

public class CmtDeleteController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		  	/comments/comments_delete.do => CmtDeleteController
		  	  =>/comments/comments_detail.do로 리다이렉트
		 */
		String no=request.getParameter("no");
		String bookNo=request.getParameter("bookNo");
		System.out.println("deleteConteriller : no="+no+" , bookNo="+bookNo);
		CommentsService cmtservice=new CommentsService();
		try {
			int cnt=cmtservice.deleteCmt(Integer.parseInt(no));
			if(cnt>0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "/comments/comments_detail.do?no="+bookNo;
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}

