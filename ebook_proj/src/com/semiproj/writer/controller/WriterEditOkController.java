package com.semiproj.writer.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semiproj.common.Utility;
import com.semiproj.writer.model.WriterService;
import com.semiproj.writer.model.WriterVO;

public class WriterEditOkController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		//파일 업로드
		String saveDir=Utility.TEST_DIR;
		//=> 프로젝트 때 통합을 위해 Utility에서 경로 설정해주기

		int maxSize=50*1024*1024;
		DefaultFileRenamePolicy policy=new DefaultFileRenamePolicy();

		MultipartRequest mr=null;
		String photoFileName="", photoOriginFileName="";
		try{
			mr=new MultipartRequest(request, saveDir, maxSize, "utf-8", policy);
			System.out.println("업로드 완료!");

			photoFileName=mr.getFilesystemName("imgUpload");
			photoOriginFileName=mr.getOriginalFileName("imgUpload");
		}catch(IOException e){
			System.out.println("파일 용량 초과!!");
			e.printStackTrace();
		}


		String no=mr.getParameter("no");
		String name=mr.getParameter("name");
		String intro=mr.getParameter("intro");
		String oldPhotoFileName=mr.getParameter("oldPhotoFileName");


		WriterService service=new WriterService();
		String msg="수정 실패!", url="/writer/writerEdit.do?no="+no;


		WriterVO vo=new WriterVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setIntro(intro);
		vo.setPhotoFileName(photoFileName);
		vo.setPhotoOriginFileName(photoOriginFileName);

		try {
			int cnt=service.updateWriter(vo);
			if(cnt>0) {
				//기존 파일이 존재하면 기존 파일 삭제
				if(photoFileName!=null && !photoFileName.isEmpty()){
					File oldFile=new File(saveDir, oldPhotoFileName);
					if(oldFile.exists()){ //존재한다면
						boolean bool=oldFile.delete();
						System.out.println("기존 이미지 파일 삭제 여부:"+bool);
					}
				}
				msg="수정 성공";
				url="/writer/writerPage.do?no="+no;
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
