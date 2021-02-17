package com.semiproj.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.semiproj.member.model.MemberService;

public class CheckNicknameOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String nickname = request.getParameter("nickname");
		//
		MemberService service = new MemberService();

		System.out.println("okcontrollnickname="+nickname);
		if(nickname==null || nickname.isEmpty()) {
			request.setAttribute("msg", "nickname을 입력하세요.");
			request.setAttribute("url", "/member/checkNickname.jsp");
			
			return "/common/message.jsp";
		}
		
		int result=0;
		try {
			result = service.checkNickname(nickname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("별명 체크result="+result);

		if (result==service.EXIST_NICKNAME) {
			request.setAttribute("msg", "이미 등록된 별명입니다.");
			request.setAttribute("url", "/member/checkNickname.jsp");
			request.setAttribute("nickname", nickname);
			return "/common/message.jsp";
		}else if (result==service.NON_EXIST_NICKNAME) {
			request.setAttribute("msg", "사용가능한 별명입니다.사용하시겠습니까?");
			request.setAttribute("url", "/member/checkNickname.do");
			request.setAttribute("result", result);
			request.setAttribute("email", nickname);
			return "/common/messageNick.jsp";
		}
		
		return "reg.do";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
