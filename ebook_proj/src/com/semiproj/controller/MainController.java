package com.semiproj.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;
import com.semiproj.member.model.MemberVO;

public class MainController implements Controller{
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		MemberVO vo =(MemberVO) session.getAttribute("memVo");
		
		System.out.println("디버깅용 회원 정보 vo="+vo);
		
		//베스트셀러
		BookInfoService bookService=new BookInfoService();
		List<BookInfoVO> bookList=null;
		try {
			bookList=bookService.selectTop3();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("bookList", bookList);
		
		
		return "/main.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
