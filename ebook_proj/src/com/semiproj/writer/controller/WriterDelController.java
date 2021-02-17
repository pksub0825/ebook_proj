package com.semiproj.writer.controller;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.writer.model.WriterService;

public class WriterDelController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//1.
		String no=request.getParameter("no");
		if(no==null || no.isEmpty()) {
			request.setAttribute("msg", "잘못된 url");
			request.setAttribute("url", "/writer/writerList.do");

			return "/common/message.jsp";
		}

		String photoFileName=request.getParameter("photoFileName");

		//2
		WriterService service=new WriterService();

		String msg="책 정보 삭제 실패!", url="/writer/writerPage.do?no="+no;
		try {
			int cnt=service.deleteWr(Integer.parseUnsignedInt(no));
					
			if(cnt>0) { //삭제에 성공했을 때
				String saveDir="D:\\semiProject\\WebContent\\file_upload\\writer";
				if(photoFileName!=null && !photoFileName.isEmpty()) {
					File delFile=new File(saveDir, photoFileName);
					if(delFile.exists()){
						boolean bool=delFile.delete();
						System.out.println("텍스트 첨부파일 삭제 여부:"+bool);
					}
				}
				
				msg="작가 정보 삭제 성공!";
				url="/writer/writerList.do";
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
