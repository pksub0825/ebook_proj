package com.semiproj.bookinfo.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;
import com.semiproj.common.PagingVO;
import com.semiproj.member.model.MemberVO;

public class BookListController implements Controller{
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		String condition=request.getParameter("srchCondition");
		String keyword=request.getParameter("srchKeyword");
		
		//세션에 담긴 닉네임 빼오기
		HttpSession session = request.getSession();
		MemberVO memVo =(MemberVO) session.getAttribute("memVo");
		
		String nickname="";
		if(memVo!=null) nickname=memVo.getNickname();
				
		//2.
		BookInfoService service=new BookInfoService();
		
		List<BookInfoVO> list=null;
		try {
			list=service.selectAll(condition, keyword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		//페이징처리
		int currentPage=1;
		if(request.getParameter("curPage")!=null
				&& !request.getParameter("curPage").isEmpty()) {
			currentPage
				=Integer.parseInt(request.getParameter("curPage"));
		}
		
		int totalRecord=0;
		if(list!=null) totalRecord=list.size();
				
		int pageSize=5, blockSize=10;
	
		PagingVO pageVo=new PagingVO(currentPage, totalRecord, pageSize, blockSize);
		
		//3.
		request.setAttribute("bookList", list);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("nickname", nickname);
		
		//4.
		return "/book/bookList.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
