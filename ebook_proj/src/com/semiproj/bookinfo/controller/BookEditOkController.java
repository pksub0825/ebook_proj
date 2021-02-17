package com.semiproj.bookinfo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semiproj.bookinfo.model.BookInfoService;
import com.semiproj.bookinfo.model.BookInfoVO;

public class BookEditOkController implements Controller{

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
		
		String no=mr.getParameter("no");
		String title=mr.getParameter("title");
		String price=mr.getParameter("price");
		String publisher=mr.getParameter("publisher");
		String wrNo=mr.getParameter("wrNo");
		String content=mr.getParameter("content");
		String oldTxtFileName=mr.getParameter("oldTxtFileName");
		String oldCoverFileName=mr.getParameter("oldCoverFileName");
		
		//2.
		BookInfoService service=new BookInfoService();
		BookInfoVO vo=new BookInfoVO();
		vo.setNo(Integer.parseInt(no));
		vo.setTitle(title);
		vo.setPrice(Integer.parseInt(price));
		vo.setPublisher(publisher);
		vo.setWrNo(Integer.parseInt(wrNo));
		vo.setContent(content);
		vo.setTxtFileName(txtFileName);
		vo.setCoverFileName(coverFileName);
		vo.setTxtOriginFileName(txtOriginFileName);
		vo.setCoverOriginFileName(coverOriginFileName);
		
		String msg="책 정보 수정 실패", url="/book/bookWrite.do";
		try {
			int cnt=service.updateBook(vo);
			if(cnt>0) {
				//기존 파일이 존재하면 기존 파일 삭제
				if(txtFileName!=null && !txtFileName.isEmpty()){
					File oldFile=new File(saveDir, oldTxtFileName);
					if(oldFile.exists()){ //존재한다면
						boolean bool=oldFile.delete();
						System.out.println("기존 텍스트 파일 삭제 여부:"+bool);
					}
				}
				if(coverFileName!=null && !coverFileName.isEmpty()){
					File oldFile=new File(saveDir, oldCoverFileName);
					if(oldFile.exists()){ //존재한다면
						boolean bool=oldFile.delete();
						System.out.println("기존 책표지 파일 삭제 여부:"+bool);
					}
				}
				
				msg="책 정보 수정 성공!";
				url="/book/bookDetail.do?no="+no;
			}else {
				File delTxtFile=new File(saveDir, txtFileName);
				if(delTxtFile.exists()){
					boolean bool=delTxtFile.delete();
					System.out.println("책 정보 수정 실패 시, 업로드된 텍스트 파일 삭제 여부:"+bool);
				}
				
				File delCoverFile=new File(saveDir, coverFileName);
				if(delCoverFile.exists()){
					boolean bool=delCoverFile.delete();
					System.out.println("책 정보 수정 실패 시, 업로드된 책표지 파일 삭제 여부:"+bool);
				}
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
