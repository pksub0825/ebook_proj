package com.semiproj.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.semiproj.member.model.MemberService;
import com.semiproj.member.model.MemberVO;

public class MemberEditOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		/member/memberEdit_ok.do - > memberEditOkCOntroller
		-> /member/memberDetail.do  redirect
		*/
		
		String pwd=request.getParameter("pwd");
		String address=request.getParameter("address");
		String hp1=request.getParameter("hp1");
		String hp2=request.getParameter("hp2");
		String hp3=request.getParameter("hp3");
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nickname");
		
		System.out.println("hp1="+hp1);
		System.out.println("hp2="+hp2);
		System.out.println("hp3="+hp3);
		
		String hp=""; //email="";
		if(hp2!=null && !hp2.isEmpty() && hp3!=null && !hp3.isEmpty()){
			hp=hp1+"-"+hp2+"-"+hp3;
		}
		
		/*if(email1!=null && !email1.isEmpty()){
			if(email2.equals("etc")){
				if(email3!=null && !email3.isEmpty()){
					email= email1+"@"+email3;
				}
			}else{
				email=email1+"@"+email2;
			}
		}*/
		
		System.out.println("hp="+hp);
		System.out.println("email="+email);
		
		//2
		MemberService service = new MemberService();
		
		MemberVO vo = new MemberVO();
		vo.setAddress(address);
		vo.setEmail(email);
		vo.setHp(hp);
		vo.setName(name);
		vo.setNickname(nickname);
		vo.setPwd(pwd);
		
		String msg="회원정보 수정 실패", url="/member/memberEdit.do";
		try {
			int cnt = service.updateMember(vo);
			
			if (cnt>0) {
				msg="회원정보 수정 완료.";
				url="/main.do";
				request.getSession().setAttribute("memVo", vo);
				request.setAttribute("msg", "정보 수정 완료.");
				request.setAttribute("url", "/main.do");
				HttpSession session = request.getSession();
				session.setAttribute("memVo", vo);
				return "/common/message.jsp";
			}
		}catch (SQLException e) {
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
