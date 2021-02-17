package com.semiproj.writer.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;
import com.semiproj.common.PagingVO;
import com.semiproj.member.model.MemberVO;
import com.semiproj.writer.model.WriterService;
import com.semiproj.writer.model.WriterVO;

public class WriterPageController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String no=request.getParameter("no");
		String condition=request.getParameter("srchCondition");
		String keyword=request.getParameter("srchKeyword");
		
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다");
			request.setAttribute("url", "/board/list.do");
			
			return "/common/message.jsp";
			
		}
		
		//관리자 확인
		MemberVO memVo=(MemberVO)request.getSession().getAttribute("memVo");
		String nickname="";
		if(memVo!=null) nickname=memVo.getNickname();
		
		//
		WriterService service=new WriterService();
		WriterVO vo=null;

		BookInfoService service2=new BookInfoService();
		List<BookInfoVO> list=null;
		
		try {
			vo=service.selectByNo(Integer.parseInt(no));
			list=service2.selectByWrno(Integer.parseInt(no));
			
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
		
		request.setAttribute("vo", vo);
		request.setAttribute("bookList", list);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("nickname", nickname);
		
		return "/writer/writerPage.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
	
	
}
