package com.semiproj.writer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semiproj.writer.model.WriterService;
import com.semiproj.writer.model.WriterVO;

public class WriterInsertOkController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		//파일 업로드
		String saveDir="C:\\lecture\\workspace_list\\proj_ws\\semiproj\\WebContent\\file_upload";
		//=> 프로젝트 때 통합을 위해 Utility에서 경로 설정해주기

		int maxSize=50*1024*1024;
		DefaultFileRenamePolicy policy=new DefaultFileRenamePolicy();

		MultipartRequest mr=null;
		String photoFileName="", photoOriginFileName="";
		try{
			mr=new MultipartRequest(request, saveDir, maxSize, "utf-8", policy);
			System.out.println("업로드 완료!");
		 
			photoFileName=mr.getFilesystemName("writerUpload");
			photoOriginFileName=mr.getOriginalFileName("writerUpload");
		 
		}catch(IOException e){
			System.out.println("파일 용량 초과!!");
			e.printStackTrace();
		}


		String name=mr.getParameter("name");
		String intro=mr.getParameter("intro");

		WriterService service=new WriterService();

		WriterVO vo=new WriterVO();
		vo.setName(name);
		vo.setIntro(intro);
		vo.setPhotoFileName(photoFileName);
		vo.setPhotoOriginFileName(photoOriginFileName);
		
		String msg="작가 등록 실패", url="/writer/writeInsert.do";
		
		
		try {
			int cnt=service.insertWriter(vo);

			if(cnt>0) {
				msg="작가 등록 성공!";
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
