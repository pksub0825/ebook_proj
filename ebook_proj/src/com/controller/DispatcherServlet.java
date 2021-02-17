package com.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	/tips/book.do
	/tips/travel.do
=> 모든 요청이 DispatcherServlet으로 들어온다
=> 매핑파일을 참고해서 담당자(명령어 처리 클래스)를 구하여 일을 시킨다(메서드 호출)
*/
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Properties props;
	
	//init() - 해당 서블릿이 요청될 때 최초로 한 번만 호출되는 메서드
	//매핑 파일을 읽어서 Properties컬렉션에 저장한다
	@Override
	public void init(ServletConfig config) throws ServletException {
		//web.xml에서 init-param의 값 읽어오기
		String configFile=config.getInitParameter("configFile");
		//=> /config/CommandPro.properties
		System.out.println("configFile="+configFile);
		
		//매핑 파일의 실제 물리적인 경로 구하기
		String realConfigFile
			=config.getServletContext().getRealPath(configFile);
		System.out.println("realConfigFile="+realConfigFile+"\n");
		
		
		props=new Properties();
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(realConfigFile);
			props.load(fis);//CommandPro.properties파일의 정보를
							//Properties컬렉션에 저장
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(fis!=null) fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	//사용자의 요청이 들어올 때마다 호출됨
	//매핑 Properties를 참고하여 담당자를 구해서 일을 시킨다
	private void requestPro(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		/*
		 매핑 Properties 컬렉션에서 사용자의 URI에 해당하는
		 담당자 (명령어 처리 클래스)를 구해서
		 일을 시킨다 (해당 컨트롤러의 메서드 호출)
		 그리고 나서, 결과를 리턴 받아 해당 뷰페이지로 포워딩시킨다
		*/
		
		//한글 처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//사용자의 URI 읽어오기
		String uri=request.getRequestURI();
		System.out.println("uri="+uri);
		
		//uri 중 ContextPath 제거하기
		String contextPath=request.getContextPath(); //=> /semiproj
		System.out.println("contextPath="+contextPath);
		
		if(uri.indexOf(contextPath)!=-1) {//uri에 contextPath가 있다면
			//'/'의 인덱스 위치 = contextPath의 글자 길이
			uri=uri.substring(contextPath.length());
			//=> /~.do
		}
		
		System.out.println("컨텍스트 패스 제거 후 uri="+uri);
		
		//명령어에 해당하는 명령어 처리 클래스 구하기
		String command=props.getProperty(uri);
		System.out.println("명령어 처리 클래스 command="+command);

		try {
			//해당 문자열을 클래스로 만든다
			Class commandClass=Class.forName(command);
			
			//해당 클래스의 객체 생성
			Controller controller
				=(Controller)commandClass.newInstance();
			//=> 모든 담당자들은 Controller를 implements했기 때문에 가능
			
			//해당 클래스의 메서드 호출
			String resultPage
				=controller.requestProcess(request, response);
			System.out.println("resultPage="+resultPage);
			//=> 자식의 오버라이드 메서드가 호출 됨
			
			if(controller.isRedirect()) {
				//해당 페이지로 redirect
				System.out.println("redirect!!\n");
				response.sendRedirect(contextPath+resultPage);
			}else {
				//해당 뷰 페이지로 포워딩
				System.out.println("forward!!\n");
				RequestDispatcher dispatcher
				=request.getRequestDispatcher(resultPage);
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
