package com.semiproj.bookinfo.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.common.PagingVO;
import com.semiproj.writer.model.WriterService;
import com.semiproj.writer.model.WriterVO;

public class FindWriterController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		String writer=request.getParameter("writer");
		
		//2.
		WriterService service=new WriterService();
		List<WriterVO> list=null;
		try{
			if(writer!=null && !writer.isEmpty()){
				list=service.selectByName(writer);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		//페이징 처리
		int curPage=1;
		if(request.getParameter("curPage")!=null){
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}
		
		int totalRecord=0;
		if(list!=null && !list.isEmpty()){
			totalRecord=list.size();
		}
		
		int pageSize=25;
		int blockSize=10;
		
		PagingVO pageVo=new PagingVO(curPage, totalRecord, pageSize, blockSize);
		
		//3.
		request.setAttribute("wList", list);
		request.setAttribute("pageVo", pageVo);
		
		//4.
		return "/book/findWriter.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
