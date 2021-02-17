package com.semiproj.eventboard.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.common.Utility;
import com.semiproj.eventboard.model.eventBoardService;

public class EventDownCountController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
			8. 업로드파일 다운로드하기
			
			/eventBoard/eventDownCount.do => EventDownCountController
			=> eventDetail.jsp로 포워드 
		*/
		//1. 요청 파라미터 읽어오기
		//[1] 다운로드 수 증가
		String no=request.getParameter("no");
		String imgFileName=request.getParameter("imgFileName");
		
		//2. 비즈니스 로직 처리
		eventBoardService eventService=new eventBoardService();
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		int cnt=0;
		try {
			cnt=eventService.updateDownCount(Integer.parseInt(no));
			
			//[2] 파일 다운로드 처리
			String dir=Utility.UPLOAD_DIR; //물리적인 경로
			dir=Utility.TEST_DIR;
			
			File file = new File(dir, imgFileName);
			
			response.reset(); //다운로드하기 위해 리셋하기
			
			//ContentType 형식을 지정하지 않겠다는 것
			response.setContentType("application/octet-stream");
			
			//모든 확장자의 파일들에 대해 다운로드 시 무조건 파일 다운로드
			//대화상자가 뜨도록 하는 헤더 속성
			response.setHeader("Content-Disposition", 
					"attachment;filename="
					+ new String(imgFileName.getBytes("euc-kr"),"ISO-8859-1"));
			//=> url 전송 시 ISO-8859-1로 인코딩되므로 한글 처리 위해 인코딩
			
			//out.clear();
			//out=pageContext.pushBody();
			//이를 생략하면 프로그램 상엔 이상이 없으나 이미 존재하고 있는
			//out객체로 바이트 기반의 스트림 작업을 명시하면서 오류가 발생함
			
			byte[] data=new byte[1024*1024];
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			
			int count=0;
			while((count=bis.read(data))!= -1){
				bos.write(data);
			}
			
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(bis!=null) bis.close();
				if(bos!=null) bos.close();
			}
		
			//3. request에 결과 저장
			request.setAttribute("cnt", cnt);
			
			//4. 뷰페이지 리턴
			return "/eventBoard/eventDetail.jsp";
		}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
