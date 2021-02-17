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

public class EventEditOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			6. 글 수정하기
			
			/eventBoard/eventEdit_ok.do => EventEditOkController
			=> eventList.do로 redirect
		*/

		//파일 업로드 처리
		String no=null;
		try {
			ServletContext context=request.getSession().getServletContext();
			String saveDir=context.getRealPath(Utility.UPLOAD_DIR);
			saveDir=Utility.TEST_DIR;
			
			int maxSize=2*1024*1024;
			
			MultipartRequest mr
				= new MultipartRequest(request, saveDir, maxSize,
						"utf-8", new DefaultFileRenamePolicy());
			System.out.println("파일 업로드 완료!");
			
			String imgFileName =mr.getFilesystemName("upfile");
			String imgOriginFileName="";
			
			//새로 업로드하는 경우
			if(imgFileName!=null && !imgFileName.isEmpty()) { 
				imgOriginFileName=mr.getOriginalFileName("upfile");
			}
			
			//1
			//param으로 받아온 no
			no=mr.getParameter("no");
			System.out.println("no="+no);
			String title=mr.getParameter("title");
			System.out.println("title="+title);
			
			String content=mr.getParameter("content");
			String oldFileName=mr.getParameter("oldFileName");
			
			//2
			eventBoardService eventService=new eventBoardService();		
			eventBoardVO eventVo=new eventBoardVO();
			
			eventVo.setNo(Integer.parseInt(no));
			eventVo.setTitle(title);
			eventVo.setContent(content);
			//새로 업로드되는 파일
			eventVo.setImgFileName(imgFileName);
			eventVo.setImgOriginFileName(imgOriginFileName);
			
			int cnt=eventService.updateBoard(eventVo);
			
			if(cnt>0) {
				//파일을 새로 첨부한 경우, 기존파일이 존재하면 기존파일 삭제
				if(imgFileName!=null && !imgFileName.isEmpty()) {
					File oldFile=new File(saveDir, oldFileName); //파일 객체 생성
					if(oldFile.exists()) { //기존파일이 존재하면 
						boolean bool=oldFile.delete(); //기존파일은 삭제한다
						System.out.println("기존 파일 삭제 여부 bool="+ bool);
					}
				}//안쪽if
			}//바깥if
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			String msg="2M 이상의 파일은 첨부할 수 없습니다.";
			String url="/eventBoard/eventList.do";
			
			return "/common/message.jsp";
		}
		
		//3
		//4
		return "/eventBoard/eventDetail.do?no="+no;
	}

	@Override
	public boolean isRedirect() {
		return true;	//redirect
	}

}
