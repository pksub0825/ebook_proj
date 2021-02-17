package com.semiproj.bookinfo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;

public class BookWriteOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		//파일 업로드
		String saveDir="C:\\lecture\\workspace_list\\proj_ws\\semiproj\\WebContent\\file_upload";
		//=> 프로젝트 때 통합을 위해 Utility에서 경로 설정해주기
		
		int maxSize=50*1024*1024;
		DefaultFileRenamePolicy policy=new DefaultFileRenamePolicy();
		
		MultipartRequest mr=null;
		String txtFileName="", coverFileName="", txtOriginFileName="", coverOriginFileName="";
		try{
			mr=new MultipartRequest(request, saveDir, maxSize, "utf-8", policy);
			System.out.println("업로드 완료!");
			
			txtFileName=mr.getFilesystemName("txtUpload");
			coverFileName=mr.getFilesystemName("coverUpload");
			txtOriginFileName=mr.getOriginalFileName("txtUpload");
			coverOriginFileName=mr.getOriginalFileName("coverUpload");
		}catch(IOException e){
			System.out.println("파일 용량 초과!!");
			e.printStackTrace();
		}
		
		String title=mr.getParameter("title");
		String price=mr.getParameter("price");
		String publisher=mr.getParameter("publisher");
		String wrNo=mr.getParameter("wrNo");
		String content=mr.getParameter("content");
		
		//2.
		BookInfoService service=new BookInfoService();
		BookInfoVO vo=new BookInfoVO();
		vo.setTitle(title);
		vo.setPrice(Integer.parseInt(price));
		vo.setPublisher(publisher);
		vo.setWrNo(Integer.parseInt(wrNo));
		vo.setContent(content);
		vo.setTxtFileName(txtFileName);
		vo.setCoverFileName(coverFileName);
		vo.setTxtOriginFileName(txtOriginFileName);
		vo.setCoverOriginFileName(coverOriginFileName);
		
		String msg="책 등록 실패", url="/book/bookWrite.do";
		try {
			int cnt=service.insertBook(vo);
			if(cnt>0) {
				msg="책 등록 성공!";
				url="/book/bookList.do";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//3.
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		//4.
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
