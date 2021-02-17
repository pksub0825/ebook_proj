package com.semiproj.eventboard.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semiproj.common.Utility;
import com.semiproj.eventboard.model.eventBoardService;
import com.semiproj.eventboard.model.eventBoardVO;

public class EventWriteOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			2. 게시판 글쓰기
			
			/eventBoard/eventWrite_ok.do => EventWriteOkController
			=> eventList.do로 redirect 
		*/
		//파일 업로드 처리
		try {
			String upPath=Utility.UPLOAD_DIR;
			ServletContext context = request.getSession().getServletContext(); //절대경로를 구하는 ServletContext 구하기
			String saveDir=context.getRealPath(upPath); //절대경로
			saveDir=Utility.TEST_DIR;
			
			int maxSize=2*1024*1024; //2M
			
			MultipartRequest mr
				= new MultipartRequest(request, saveDir, maxSize, "utf-8",
							new DefaultFileRenamePolicy());
			System.out.println("업로드 완료!");
			
			//업로드 파일의 정보 구하기
			String fileName=mr.getFilesystemName("upfile"); //업로드 파일
			String originName="";
			long fileSize=0;
			
			//업로드 한 경우에만
			if(fileName!=null && !fileName.isEmpty()) {
				originName=mr.getOriginalFileName("upfile");
				
				File file=mr.getFile("upfile");
				fileSize=file.length();
			}
			
			//1. 요청 파라미터 읽어오기
			//=> http://localhost:9090/semiproj/eventBoard/eventWrite_ok.do
			//String title=request.getParameter("title");
			//String content=request.getParameter("content");
			String title=mr.getParameter("title");
			String content=mr.getParameter("content");
			
			String ip=request.getRemoteAddr();
			String ip2=request.getRemoteHost();
			System.out.println("ip="+ip+", ip2="+ ip2);
			
			//2. 비즈니스 로직 처리 - 모델에 의뢰, db 작업
			eventBoardService eventService=new eventBoardService();
			eventBoardVO eventVo=new eventBoardVO();
			eventVo.setTitle(title);
			eventVo.setContent(content);
			eventVo.setImgFileName(fileName);
			eventVo.setImgOriginFileName(originName);
			
			int cnt=eventService.insertBoard(eventVo);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			request.setAttribute("msg", "2M 이상의 파일은 업로드할 수 없습니다.");
			request.setAttribute("url", "/eventBoard/eventWrite.do");
			
			return "/common/message.jsp";
		}
		
		//3
		//4. 뷰페이지 리턴
		return "/eventBoard/eventList.do";
	}

	@Override
	public boolean isRedirect() {
		return true;	//redirect
	}

}
