package com.semiproj.comments.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.comments.model.CommentsService;
import com.semiproj.comments.model.CommentsVO;

public class CmtEditOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 * /comments/comments_edit_ok.do => CmtEditOkController
	 * ==>comments_detail.do로 리다이렉트
		 */
		String bookNo=request.getParameter("bookNo");
		String no=request.getParameter("no");
		//String nickname=request.getParameter("nickname");
		String content=request.getParameter("content");
		
		CommentsService service=new CommentsService();
		String msg="수정에 실패했습니다.", url="/comments/comments_detail.do";
		try {
			CommentsVO vo=new CommentsVO();
			vo.setNo(Integer.parseInt(no));
			vo.setContent(content);
			
			int cnt=service.updateCmt(vo);
			if(cnt>0) {
				msg="댓글 수정 성공";
				
				url="/comments/comments_detail.do?no="+bookNo;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//3.
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		//4.
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
