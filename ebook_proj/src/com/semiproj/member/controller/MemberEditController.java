package com.semiproj.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.semiproj.member.model.MemberService;
import com.semiproj.member.model.MemberVO;

public class MemberEditController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 수정화면
		MemberVO vo =(MemberVO)request.getSession().getAttribute("memVo");
		
		if(vo==null) {
			request.setAttribute("msg", "로그인 후에 이용해주세요.");
			request.setAttribute("url", "/login/login.do");
			
			return "/common/message.jsp";
		}
		
		String nickname = vo.getNickname();
		System.out.println("nickname="+nickname);
		
		String email = vo.getEmail();
		System.out.println("email="+email);
		
		/*
		String email=request.getParameter("email");
		System.out.println("email="+email);
		String nickname= request.getParameter("nickname");
		*/
		
		//안해도 되는 유효성 검사
		/*if(nickname==null || nickname.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다.");
			request.setAttribute("url", "/main.do");
			
			return "/common/message.jsp";
		}*/
		
		MemberService service = new MemberService();
				
		try {
			vo=service.selectMember(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//String address=vo.getAddress();
		//if(address==null) address="";
		
		String hp=vo.getHp();
		String hp1="", hp2="", hp3="";
		//String email1="", email2="";
		if(hp!=null && !hp.isEmpty()){   //010-100-2000
			String[] hpArr=hp.split("-");
			hp1=hpArr[0];   //010
			hp2=hpArr[1];   //100
			hp3=hpArr[2];   //2000
		}
		
		//email는 원래 변경불가
		/*String[] emailList
		={"naver.com","hanmail.net","nate.com","gmail.com"};

		int count=0;
		String isEtc="n"; //직접입력이 아닌 경우 n
		if(email!=null && !email.isEmpty()){
			String[] emailArr=email.split("@");
			email1=emailArr[0]; //h, k
			email2=emailArr[1]; //nate.com, herb.com

			//for문 돌려서 일치하는게 있다면 count++
			for(int i=0;i<emailList.length;i++){
				if(email2.equals(emailList[i])){
					count++;
					break;
				}
			}//for

			//count값에 따라서 직접입력이다 / 아니다 구분
			if(count==0){
				isEtc="y";   //직접입력
			}
		}*/
		
		//System.out.println("email1="+email1);
		//System.out.println("email2="+email2);
		//System.out.println("isEtc="+isEtc);
		System.out.println("hp1="+hp1);
		System.out.println("hp2="+hp2);
		System.out.println("hp3="+hp3);
		
		request.setAttribute("memVo", vo);
		request.setAttribute("hp1", hp1);
		request.setAttribute("hp2", hp2);
		request.setAttribute("hp3", hp3);
		//request.setAttribute("isEtc", isEtc);
		//request.setAttribute("email1", email1);
		//request.setAttribute("email2", email2);
		
		return "/member/memberEdit.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
}
