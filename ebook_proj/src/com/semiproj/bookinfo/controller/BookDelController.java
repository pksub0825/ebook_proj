package com.semiproj.bookinfo.controller;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;

public class BookDelController implements Controller {
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		String no=request.getParameter("no");
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url");
			request.setAttribute("url", "/book/bookList.do");
			
			return "/common/message.jsp";
		}
		
		String txtFileName=request.getParameter("txtFileName");
		String coverFileName=request.getParameter("coverFileName");
		
		//2
		BookInfoService service=new BookInfoService();
		
		String msg="책 정보 삭제 실패!", url="/book/bookDetail.do?no="+no;
		try {
			int cnt=service.deleteBook(Integer.parseInt(no));
			if(cnt>0) { //삭제에 성공했을 때
				String saveDir="C:\\lecture\\workspace_list\\proj_ws\\semiproj\\WebContent\\file_upload";
				if(txtFileName!=null && !txtFileName.isEmpty()) {
					File delFile=new File(saveDir, txtFileName);
					if(delFile.exists()){
						boolean bool=delFile.delete();
						System.out.println("텍스트 첨부파일 삭제 여부:"+bool);
					}
				}
				if(coverFileName!=null && !coverFileName.isEmpty()) {
					File delFile=new File(saveDir, coverFileName);
					if(delFile.exists()){
						boolean bool=delFile.delete();
						System.out.println("책표지 첨부파일 삭제 여부:"+bool);
					}
				}
				msg="책 정보 삭제 성공!";
				url="/book/bookList.do";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
