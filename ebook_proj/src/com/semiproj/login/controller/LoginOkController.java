package com.semiproj.login.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.semiproj.member.model.MemberService;
import com.semiproj.member.model.MemberVO;

public class LoginOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		
		String msg="로그인 처리 실패", url="/login/login.do";
		
		MemberService service = new MemberService();
		
		
		try{

			int result=service.loginCheck(email, pwd);

			MemberVO vo=service.selectMember(email);
			System.out.println(vo);
			
			if(result==MemberService.LOGIN_OK){
				//1)세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("memVo", vo);
				
				msg=vo.getNickname() + "님 로그인 되었습니다.";
				url="/main.do";
				
			}else if(result==MemberService.PWD_DISAGREE){
				msg="비밀번호가 일치하지 않습니다.";
			}else if(result==MemberService.EMAIL_NONE){
				msg="이메일이 존재하지 않습니다.";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		//3
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/common/message.jsp";
		
	}
	
	@Override
	public boolean isRedirect() {
		return false;
	}

}
