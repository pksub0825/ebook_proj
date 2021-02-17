package com.semiproj.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.semiproj.member.model.MemberService;
import com.semiproj.member.model.MemberVO;

public class MemberOutOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//입력한 비밀번호
		String pwd=request.getParameter("pwd");
		
		MemberVO vo =(MemberVO)request.getSession().getAttribute("memVo");
		System.out.println("탈퇴 정보 조회 결과 vo="+vo);
		
		//db의 비밀번호와 일치 여부
		if(!vo.getPwd().equals(pwd)) {
			request.setAttribute("msg", "비밀번호가 다릅니다.");
			request.setAttribute("url", "/member/memberOut.do");
			
			return "/common/message.jsp";
		}
		
		String email = vo.getEmail();
		System.out.println("email="+email);
		
		MemberService service = new MemberService();
		
		String msg="회원 탈퇴 실패!", url="/member/memberEdit.do";
		try {
			int cnt = service.withdrawMember(email);
			if(cnt>0) {
				msg="회원 탈퇴 되었습니다.";
				url="/main.do";
				request.getSession().invalidate();
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
