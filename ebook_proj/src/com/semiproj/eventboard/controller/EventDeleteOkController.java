package com.semiproj.eventboard.controller;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.common.Utility;
import com.semiproj.eventboard.model.eventBoardService;

public class EventDeleteOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*
			8. 글 삭제하기
		
			/eventBoard/eventDelete_ok.do => EventDeleteOkController
			=> eventList.do로 redirect
		*/
		//1
		String no=request.getParameter("no");
		//삭제할 첨부파일명
		String imgFileName=request.getParameter("imgFileName");
		
		//2
		eventBoardService eventService=new eventBoardService();
		
		try {
			int cnt=eventService.deleteBoard(Integer.parseInt(no));
			
			//기존 파일이 존재하면 삭제
			if(imgFileName!=null && !imgFileName.isEmpty()) {
				//기존 파일 경로 설정하기
				ServletContext context=request.getSession().getServletContext();
				String saveDir=context.getRealPath(Utility.UPLOAD_DIR);
				saveDir=Utility.TEST_DIR;
				
				//파일 객체 만들기 => 지우기 위해선 파일 객체 생성해야 함
				File oldFile = new File(saveDir, imgFileName);
				if(oldFile.exists()) {
					boolean bool=oldFile.delete();
					System.out.println("기존 파일 삭제 여부 :"+ bool);
				}
			}//if
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//3
		//4
		return "/eventBoard/eventList.do";
	}

	@Override
	public boolean isRedirect() {
		return true;	//redirect
	}

}
